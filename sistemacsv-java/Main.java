import model.Registro;
import service.RelatorioService;
import util.CsvReader;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Registro> registros = CsvReader.lerCsv();

        LocalDate inicio = LocalDate.of(2024, 1, 1);
        LocalDate fim = LocalDate.of(2024, 1, 31);

        List<Registro> filtrados =
            RelatorioService.filtrarPorPeriodo(registros, inicio, fim);

        RelatorioService.gerarRelatorio(filtrados);
    }
}
