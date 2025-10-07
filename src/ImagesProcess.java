import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImagesProcess implements Runnable {

    private final File imageFile;

    public ImagesProcess(File imageFile) {
        this.imageFile = imageFile;
    }

    @Override
    public void run() {
        try {
            BufferedImage original = ImageIO.read(imageFile);
            if (original == null) {
                System.err.println("Não foi possível ler a imagem " + imageFile.getName());
                return;
            }

            BufferedImage gray = ImageUtils.toGrayScale(original);

            File outputDir = new File("images");
            if (!outputDir.exists()) {
                outputDir.mkdirs();
            }

            String outputName = "images/gray_" + imageFile.getName();
            ImageIO.write(gray, "jpg", new File(outputName));
            System.out.println("Imagem processada: " + outputName);

        } catch (IOException e) {
            System.err.println("Erro ao processar " + imageFile.getName() + ": " + e.getMessage());
        }
    }
}
