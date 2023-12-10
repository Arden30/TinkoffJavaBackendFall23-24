package edu.project4.fractals.correction;

import edu.project4.model.FractalImage;
import edu.project4.model.Pixel;
import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

public class GammaCorrection {
    private static final double GAMMA = 2;

    public void applyProcedure(FractalImage canvas) {
        setPixelNormal(canvas);
        double maxGamma = getMaxGamma(canvas);
        rePaintCanvas(canvas, maxGamma);
    }

    private void rePaintCanvas(FractalImage canvas, double maxGamma) {
        Set<Pixel> correctedPixels = new HashSet<>();
        for (int column = 0; column < canvas.getWidth(); column++) {
            for (int row = 0; row < canvas.getHeight(); row++) {
                var pixel = canvas.getPixel(column, row);
                if (!correctedPixels.contains(pixel)) {
                    rePaintPixel(pixel, maxGamma);
                }
                correctedPixels.add(pixel);
            }
        }
    }

    private void rePaintPixel(Pixel pixel, double maxGamma) {
        pixel.setNormal(pixel.getNormal() / maxGamma);

        double coefficient = Math.pow(pixel.getNormal(), (1 / GAMMA));

        int red = (int) (pixel.getColor().getRed() * coefficient);
        int green = (int) (pixel.getColor().getGreen() * coefficient);
        int blue = (int) (pixel.getColor().getBlue() * coefficient);

        Color newColor = new Color(red, green, blue);

        pixel.setColor(newColor);
    }

    private void setPixelNormal(FractalImage canvas) {
        for (int column = 0; column < canvas.getWidth(); column++) {
            for (int row = 0; row < canvas.getHeight(); row++) {
                var pixel = canvas.getPixel(column, row);
                if (pixel.getHits() != 0) {
                    pixel.setNormal(Math.log10(pixel.getHits()));
                }
            }
        }
    }

    private double getMaxGamma(FractalImage canvas) {
        double maxGamma = Double.MIN_VALUE;

        for (int column = 0; column < canvas.getWidth(); column++) {
            for (int row = 0; row < canvas.getHeight(); row++) {
                var pixel = canvas.getPixel(column, row);
                if (pixel.getHits() != 0) {
                    maxGamma = Math.max(maxGamma, pixel.getNormal());
                }
            }
        }

        return maxGamma;
    }
}
