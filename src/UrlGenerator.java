package src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UrlGenerator {

    public static void generate(int n) {
        String baseUrl = "https://picsum.photos/seed/%d/800/600";
        String outputFile = "src/imagesUrls.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (int i = 1; i <= n; i++) {
                String url = String.format(baseUrl, i);
                writer.write(url);
                writer.newLine();
            }
            System.out.println("Arquivo 'imagesUrls.txt' gerado com " + n + " URLs de imagens");
        } catch (IOException e) {
            System.err.println("Erro ao gerar arquivo de URLs " + e.getMessage());
        }
    }
}
