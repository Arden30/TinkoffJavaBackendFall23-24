package edu.project4.model;

public class FractalImage {
    private final int height;
    private final int width;
    private Pixel[][] canvas;

    public FractalImage(int width, int height) {
        this.height = height;
        this.width = width;

        fillCanvas();
    }

    private void fillCanvas() {
        canvas = new Pixel[width][height];
        for (int column = 0; column < width; column++) {
            for (int row = 0; row < height; row++) {
                canvas[column][row] = new Pixel();
            }
        }
    }

    public Pixel getPixel(int x, int y) {
        return canvas[x][y];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
