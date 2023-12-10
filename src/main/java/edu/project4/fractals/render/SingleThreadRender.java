package edu.project4.fractals.render;

import edu.project4.fractals.AffineTransformation;
import edu.project4.fractals.transformations.Transformation;
import edu.project4.model.FractalImage;
import edu.project4.model.Point;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SingleThreadRender implements Renderer {
    private static final double X_MIN = -1;
    private static final double X_MAX = 1;
    private static final int Y_MIN = -1;
    private static final int Y_MAX = 1;

    @Override
    public void render(
        FractalImage canvas,
        int samples,
        int iterPerSample,
        int offset,
        List<AffineTransformation> transformations,
        List<Transformation> variations
    ) {
        int n = 0;
        for (int sample = 0; sample < samples; sample++) {
            Point point = new Point(
                ThreadLocalRandom.current().nextDouble(X_MIN, X_MAX),
                ThreadLocalRandom.current().nextDouble(Y_MIN, Y_MAX)
            );

            for (int i = offset; i < iterPerSample; i++) {
                AffineTransformation transformation =
                    transformations.get(ThreadLocalRandom.current().nextInt(0, transformations.size()));

                point = transformation.apply(point);
                point = applyPointFunctions(point, variations, n % variations.size());
                n++;

                if (i >= 0 && checkPoint(point)) {
                    int x = canvas.getWidth() - (int) (((X_MAX - point.x()) / (X_MAX - X_MIN)) * canvas.getWidth());
                    int y = canvas.getHeight() - (int) (((Y_MAX - point.y()) / (Y_MAX - Y_MIN)) * canvas.getHeight());

                    if (x < canvas.getWidth() && y < canvas.getHeight()) {
                        paintPixel(x, y, canvas, transformation.color());
                    }
                }
            }
        }
    }

    public boolean checkPoint(Point point) {
        return (point.x() >= X_MIN && point.x() <= X_MAX)
            && (point.y() >= Y_MIN && point.y() <= Y_MAX);
    }
}
