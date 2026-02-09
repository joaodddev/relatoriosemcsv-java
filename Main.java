// Estrutura do projeto | Main.java ├── class Registro ├── class RelatorioService ├── class CsvReader └── public class Main
// Formato do CSV | data,descricao,valor 2024-01-05,Abastecimento,1500.50 2024-01-10,Manutencao,800.00 2024-01-15,Frete,1200.75

// Importação de Bibliotecas 
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.HashMap;

// classe de dados (Registro)
class Registro {
    LocalDate data;
    String descricao;
    double valor;

    public Registro(LocalDate data, String descricao, double valor) {
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
    }
}

// Simular leitura do CSV

class CsvReader {

    public static List<Registro> lerCsv() {
        List<Registro> registros = new ArrayList<>();

        String csv =
            "data,descricao,valor\n" +
            "2024-01-05,Abastecimento,1500.50\n" +
            "2024-01-10,Manutencao,800.00\n" +
            "2024-01-15,Frete,1200.75\n" +
            "2024-02-02,Abastecimento,950.00";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String[] linhas = csv.split("\n");

        for (int i = 1; i < linhas.length; i++) {
            String[] colunas = linhas[i].split(",");

            LocalDate data = LocalDate.parse(colunas[0], formatter);
            String descricao = colunas[1];
            double valor = Double.parseDouble(colunas[2]);

            registros.add(new Registro(data, descricao, valor));
        }

        return registros;
    }
}

// Criar o serviço de relatório
class RelatorioService {

    public static void gerarRelatorio(List<Registro> registros) {

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
        DecimalFormat df = new DecimalFormat("#,##0.00", symbols);

        double total = 0;
        double maior = Double.MIN_VALUE;
        double menor = Double.MAX_VALUE;

        for (Registro r : registros) {
            total += r.valor;

            if (r.valor > maior) maior = r.valor;
            if (r.valor < menor) menor = r.valor;
        }

        double media = total / registros.size();

        System.out.println("===== RELATÓRIO OPERACIONAL =====");
        System.out.println("Total de registros: " + registros.size());
        System.out.println("Valor total: R$ " + df.format(total));
        System.out.println("Valor médio: R$ " + df.format(media));
        System.out.println("Maior valor: R$ " + df.format(maior));
        System.out.println("Menor valor: R$ " + df.format(menor));

        System.out.println("\nDetalhamento:");
        for (Registro r : registros) {
            System.out.println(
                r.data + " | " +
                r.descricao + " | R$ " +
                df.format(r.valor)
            );
        }
    }

    public static List<Registro> filtrarPorPeriodo(
            List<Registro> registros,
            LocalDate inicio,
            LocalDate fim) {

        List<Registro> filtrados = new ArrayList<>();

        for (Registro r : registros) {
            if ((r.data.isEqual(inicio) || r.data.isAfter(inicio)) &&
                (r.data.isEqual(fim) || r.data.isBefore(fim))) {
                filtrados.add(r);
            }
        }

        return filtrados;
    }

    public static void agruparPorDescricao(List<Registro> registros) {

    Map<String, Double> resumo = new HashMap<>();

    for (Registro r : registros) {
        resumo.put(
            r.descricao,
            resumo.getOrDefault(r.descricao, 0.0) + r.valor
        );
    }

    DecimalFormatSymbols symbols =
        new DecimalFormatSymbols(new Locale("pt", "BR"));
    DecimalFormat df =
        new DecimalFormat("#,##0.00", symbols);

    System.out.println("\nResumo por tipo:");
    for (String chave : resumo.keySet()) {
        System.out.println(
            chave + ": R$ " + df.format(resumo.get(chave))
        );
    }
}


}

// Classe Main (orquestra tudo)
public class Main {

    public static void main(String[] args) {

        List<Registro> registros = CsvReader.lerCsv();

        LocalDate inicio = LocalDate.of(2024, 1, 1);
        LocalDate fim = LocalDate.of(2024, 1, 31);

        List<Registro> filtrados =
            RelatorioService.filtrarPorPeriodo(registros, inicio, fim);

        RelatorioService.gerarRelatorio(filtrados);
        RelatorioService.agruparPorDescricao(filtrados);
    }
}
