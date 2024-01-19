package edu.project4.fractals.transformations;

import edu.project4.model.Point;

public class SphericalTransform implements Transformation {

    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();

        double newX = x / (x * x + y * y);
        double newY = y / (x * x + y * y);

        return new Point(newX, newY);
    }
}
