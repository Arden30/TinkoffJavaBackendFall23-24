package edu.project4.fractals.render;

import edu.project4.fractals.AffineTransformation;
import edu.project4.fractals.transformations.Transformation;
import edu.project4.model.FractalImage;
import edu.project4.model.Pixel;
import edu.project4.model.Point;
import java.awt.Color;
import java.util.List;

public interface Renderer {
    void render(
        FractalImage canvas,
        int samples,
        int iterPerSample,
        int offset,
        List<AffineTransformation> transformations,
        List<Transformation> variations
    );

    default Point applyPointFunctions(Point point, List<Transformation> variations, int n) {
        return variations.get(n).apply(point);
    }

    default void paintPixel(int x, int y, FractalImage canvas, Color color) {
        Pixel pixel = canvas.getPixel(x, y);

        if (pixel.getHits() == 0) {
            pixel.setColor(color);
        } else {
            pixel.mixColor(color);
        }

        pixel.incrementHits();
    }
}
