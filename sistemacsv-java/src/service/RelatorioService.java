package service;

import model.Registro;
import util.ArquivoUtil;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.*;

public class RelatorioService {

    private static DecimalFormat getFormatter() {
        DecimalFormatSymbols symbols =
            new DecimalFormatSymbols(Locale.of("pt", "BR"));
        return new DecimalFormat("#,##0.00", symbols);
    }

    public static List<Registro> filtrarPorPeriodo(
            List<Registro> registros,
            LocalDate inicio,
            LocalDate fim) {

        List<Registro> filtrados = new ArrayList<>();

        for (Registro r : registros) {
            if ((r.getData().isEqual(inicio) || r.getData().isAfter(inicio)) &&
                (r.getData().isEqual(fim) || r.getData().isBefore(fim))) {
                filtrados.add(r);
            }
        }
        return filtrados;
    }

    public static void gerarRelatorio(List<Registro> registros) {

        DecimalFormat df = getFormatter();
        StringBuilder relatorio = new StringBuilder();

        double total = 0;
        double maior = Double.MIN_VALUE;
        double menor = Double.MAX_VALUE;

        for (Registro r : registros) {
            total += r.getValor();
            maior = Math.max(maior, r.getValor());
            menor = Math.min(menor, r.getValor());
        }

        double media = total / registros.size();

        relatorio.append("===== RELATÓRIO OPERACIONAL =====\n");
        relatorio.append("Total de registros: ").append(registros.size()).append("\n");
        relatorio.append("Valor total: R$ ").append(df.format(total)).append("\n");
        relatorio.append("Valor médio: R$ ").append(df.format(media)).append("\n");
        relatorio.append("Maior valor: R$ ").append(df.format(maior)).append("\n");
        relatorio.append("Menor valor: R$ ").append(df.format(menor)).append("\n\n");

        relatorio.append("Detalhamento:\n");
        for (Registro r : registros) {
            relatorio.append(r.getData())
                     .append(" | ")
                     .append(r.getDescricao())
                     .append(" | R$ ")
                     .append(df.format(r.getValor()))
                     .append("\n");
        }

        relatorio.append("\nResumo por tipo:\n");

        Map<String, Double> resumo = new HashMap<>();
        for (Registro r : registros) {
            resumo.put(
                r.getDescricao(),
                resumo.getOrDefault(r.getDescricao(), 0.0) + r.getValor()
            );
        }

        for (String tipo : resumo.keySet()) {
            relatorio.append(tipo)
                     .append(": R$ ")
                     .append(df.format(resumo.get(tipo)))
                     .append("\n");
        }

        // Exibe no terminal
        System.out.println(relatorio);

        // Salva em arquivo
        ArquivoUtil.salvarEmArquivo("relatorio.txt", relatorio.toString());
    }
}
