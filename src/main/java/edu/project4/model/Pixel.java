package edu.project4.model;

import java.awt.Color;

public class Pixel {
    private Color color = Color.BLACK;
    private int hits = 0;
    private double normal = 0;

    public void incrementHits() {
        hits++;
    }

    public void mixColor(Color newColor) {
        color = new Color(
            (color.getRed() + newColor.getRed()) / 2,
            (color.getGreen() + newColor.getGreen()) / 2,
            (color.getBlue() + newColor.getBlue()) / 2
        );
    }

    public void setNormal(double normal) {
        this.normal = normal;
    }

    public int getHits() {
        return hits;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getNormal() {
        return normal;
    }
}
