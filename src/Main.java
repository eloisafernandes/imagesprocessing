package src;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = 2; // número de imagens que deseja processar
        UrlGenerator.generate(n);

        List<String> urls = readUrls("./src/imagesUrls.txt");

        List<Thread> downloadThreads = new ArrayList<>();
        List<File> downloadedFiles = new ArrayList<>();

        // Cria e inicia threads de download
        for (int i = 0; i < urls.size(); i++) {
            String url = urls.get(i);
            Downloader downloader = new Downloader(url, i, downloadedFiles);
            Thread t = new Thread(downloader);
            t.start();
            downloadThreads.add(t);
        }

        // Espera todas as threads terminarem
        for (Thread t : downloadThreads) {
            t.join();
        }

        System.out.println("Downloads concluídos OK");

        // Cria e inicia threads de processamento mundando para preto e branco
        List<Thread> processThreads = new ArrayList<>();
        long startTime = System.currentTimeMillis();

        for (File f : downloadedFiles) {
            ImagesProcess processor = new ImagesProcess(f);
            Thread t = new Thread(processor);
            t.start();
            processThreads.add(t);
        }

        // Espera todas as threads de processamento terminarem
        for (Thread t : processThreads) {
            t.join();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Todas as imagens processadas em grayscale");
        System.out.println("O tempo total de processamento foi de " + (endTime - startTime) + " ms");
    }

    private static List<String> readUrls(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }
}
