package src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UrlGenerator {
    public static void main(String[] args) {
        int n = 100;
        String baseUrl = "https://picsum.photos/seed/%d/800/600";
        String outputFile = "src/imagesUrls.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (int i = 1; i <= n; i++) {
                String url = String.format(baseUrl, i);
                writer.write(url);
                writer.newLine();
            }
            System.out.println("Arquivo 'urls.txt' gerado com " + n + " URLs!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
