package edu.project4.fractals;

import edu.project4.fractals.correction.GammaCorrection;
import edu.project4.fractals.render.MultiThreadRender;
import edu.project4.fractals.render.SingleThreadRender;
import edu.project4.fractals.transformations.DiskTransform;
import edu.project4.fractals.transformations.PolarTransform;
import edu.project4.fractals.transformations.SinusTransform;
import edu.project4.fractals.transformations.SphericalTransform;
import edu.project4.fractals.transformations.Transformation;
import edu.project4.image.ImageFormat;
import edu.project4.image.ImageUtils;
import edu.project4.model.FractalImage;
import java.awt.Color;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FractalGenerator {
    private static final int WIDTH = 1920;
    private static final int HEIGHT = 1080;
    private static final int SAMPLES = 1_000_000;
    private static final int ITERATIONS_PER_SAMPLE = 100;
    private static final int AMOUNT_OF_AFFINE_TRANSFORMATIONS = 70;
    private static final int MAX_ABSOLUTE_SHIFT = 5;
    private static final int OFFSET = -20;
    private static final int MAX_COLOR = 256;

    public void launch(Path path, String filename, ImageFormat imageFormat, int numOfThreads) {
        List<AffineTransformation> transformations = getListOfAffineTransformations();
        List<Transformation> variants =
            List.of(
                new SinusTransform(),
                new SphericalTransform(),
                new PolarTransform(),
                new DiskTransform()
            );
        FractalImage canvas = new FractalImage(WIDTH, HEIGHT);
        if (numOfThreads > 1) {
            multiThreadsGenerateFractal(transformations, variants, canvas, numOfThreads);
        } else {
            singleThreadGenerateFractal(transformations, variants, canvas);
        }
        GammaCorrection gammaCorrection = new GammaCorrection();
        gammaCorrection.applyProcedure(canvas);

        ImageUtils.renderImage(canvas, path, filename, imageFormat);
    }

    private List<AffineTransformation> getListOfAffineTransformations() {
        List<AffineTransformation> transformations = new ArrayList<>();

        for (int i = 0; i < AMOUNT_OF_AFFINE_TRANSFORMATIONS; i++) {
            transformations.add(generateAffineTransformation());
        }

        return transformations;
    }

    private static AffineTransformation generateAffineTransformation() {
        while (true) {
            double a = ThreadLocalRandom.current().nextDouble(-1, 1);
            double b = ThreadLocalRandom.current().nextDouble(-1, 1);
            double d = ThreadLocalRandom.current().nextDouble(-1, 1);
            double e = ThreadLocalRandom.current().nextDouble(-1, 1);

            double c = ThreadLocalRandom.current().nextDouble(-MAX_ABSOLUTE_SHIFT, MAX_ABSOLUTE_SHIFT);
            double f = ThreadLocalRandom.current().nextDouble(-MAX_ABSOLUTE_SHIFT, MAX_ABSOLUTE_SHIFT);

            int red = ThreadLocalRandom.current().nextInt(0, MAX_COLOR);
            int green = ThreadLocalRandom.current().nextInt(0, MAX_COLOR);
            int blue = ThreadLocalRandom.current().nextInt(0, MAX_COLOR);

            Color color = new Color(red, green, blue);

            if (areCorrectCoefficients(a, b, d, e)) {
                return new AffineTransformation(a, b, c, d, e, f, color);
            }
        }

    }

    private static boolean areCorrectCoefficients(double a, double b, double d, double e) {
        return a * a + d * d < 1
            && b * b + e * e < 1
            && a * a + b * b + d * d + e * e < 1 + (a * e - b * d) * (a * e - b * d);
    }

    public void singleThreadGenerateFractal(
        List<AffineTransformation> transformations,
        List<Transformation> variants,
        FractalImage canvas
    ) {
        SingleThreadRender singleThreadRender = new SingleThreadRender();
        singleThreadRender.render(
            canvas,
            SAMPLES,
            ITERATIONS_PER_SAMPLE,
            OFFSET,
            transformations,
            variants
        );
    }

    public void multiThreadsGenerateFractal(
        List<AffineTransformation> transformations,
        List<Transformation> variants,
        FractalImage canvas,
        int numOfThreads
    ) {
        MultiThreadRender multiThreadRender = new MultiThreadRender();
        multiThreadRender.service(
            canvas,
            SAMPLES,
            ITERATIONS_PER_SAMPLE,
            OFFSET,
            transformations,
            variants,
            numOfThreads
        );
    }
}
