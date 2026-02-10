package util;

import java.io.FileWriter;
import java.io.IOException;

public class ArquivoUtil {

    public static void salvarEmArquivo(String nomeArquivo, String conteudo) {

        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            writer.write(conteudo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }
}
