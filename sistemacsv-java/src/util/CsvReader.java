package util;

import model.Registro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public static List<Registro> lerCsv() {

        List<Registro> registros = new ArrayList<>();

        String csv =
            "data,descricao,valor\n" +
            "2024-01-05,Abastecimento,1500.50\n" +
            "2024-01-10,Manutencao,800.00\n" +
            "2024-01-15,Frete,1200.75\n" +
            "2024-02-02,Abastecimento,950.00";

        DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String[] linhas = csv.split("\n");

        for (int i = 1; i < linhas.length; i++) {
            String[] colunas = linhas[i].split(",");

            LocalDate data =
                LocalDate.parse(colunas[0], formatter);
            String descricao = colunas[1];
            double valor =
                Double.parseDouble(colunas[2]);

            registros.add(new Registro(data, descricao, valor));
        }

        return registros;
    }
}
