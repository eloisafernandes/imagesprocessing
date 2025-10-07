import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.List;

public class Downloader implements Runnable {

    private final String url;
    private final int id;
    private final List<File> downloadedFiles; 

    public Downloader(String url, int id, List<File> downloadedFiles) {
        this.url = url;
        this.id = id;
        this.downloadedFiles = downloadedFiles;
    }

    @Override
    public void run() {
        try {
            Files.createDirectories(Paths.get("images"));

            String fileName = "images/image_" + id + ".jpg";

            try (InputStream in = new URL(url).openStream()) {
                Files.copy(in, Paths.get(fileName), StandardCopyOption.REPLACE_EXISTING);
            }

            System.out.println("Download concluído: " + fileName);

            synchronized (downloadedFiles) {
                downloadedFiles.add(new File(fileName));
            }

        } catch (IOException e) {
            System.err.println("Erro ao baixar " + url + ": " + e.getMessage());
        }
    }
}
