package edu.project4.image;

import edu.project4.model.FractalImage;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import javax.imageio.ImageIO;

public final class ImageUtils {
    private ImageUtils() {
    }

    public static void renderImage(FractalImage canvas, Path path, String filename, ImageFormat imageFormat) {
        int height = canvas.getHeight();
        int width = canvas.getWidth();

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        fillGraphics(canvas, graphics);

        save(image, path, filename, imageFormat);
    }

    private static void fillGraphics(FractalImage canvas, Graphics graphics) {
        for (int x = 0; x < canvas.getWidth(); x++) {
            for (int y = 0; y < canvas.getHeight(); y++) {
                var pixel = canvas.getPixel(x, y);
                graphics.setColor(pixel.getColor());
                graphics.fillRect(x, y, 1, 1);
            }
        }
    }

    public static void save(BufferedImage image, Path path, String filename, ImageFormat format) {
        try {
            String separator = File.separator;
            String pth = path.toString() + separator + filename + format.name().toLowerCase();
            ImageIO.write(image, format.name(), new File(pth));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
