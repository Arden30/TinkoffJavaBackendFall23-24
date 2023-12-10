package edu.project4.fractals.transformations;

import edu.project4.model.Point;
import static java.lang.Math.PI;
import static java.lang.Math.atan;
import static java.lang.Math.sqrt;

public class PolarTransform implements Transformation {

    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();

        double newX = atan(y / x) / PI;
        double newY = sqrt(x * x + y * y) - 1;

        return new Point(newX, newY);
    }
}
