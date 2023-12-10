package edu.project4.fractals.transformations;

import edu.project4.model.Point;

public class DiskTransform implements Transformation {
    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();

        double arg = Math.PI * Math.sqrt(x * x + y * y);
        double coefficient = Math.atan(y / x) / Math.PI;

        double newX = coefficient * Math.sin(arg);
        double newY = coefficient * Math.cos(arg);

        return new Point(newX, newY);
    }
}
