
import java.awt.Color;
import java.awt.image.BufferedImage;

public class ImageUtils {

    public static BufferedImage toGrayScale(BufferedImage original) {
        int width = original.getWidth();
        int height = original.getHeight();

        BufferedImage gray = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = original.getRGB(x, y);
                Color color = new Color(rgb);

                // fórmula de luminância: 0.299 R + 0.587 G + 0.114 B
                int grayLevel = (int) (0.299 * color.getRed() +
                                       0.587 * color.getGreen() +
                                       0.114 * color.getBlue());
                Color grayColor = new Color(grayLevel, grayLevel, grayLevel);

                gray.setRGB(x, y, grayColor.getRGB());
            }
        }

        return gray;
    }
}
