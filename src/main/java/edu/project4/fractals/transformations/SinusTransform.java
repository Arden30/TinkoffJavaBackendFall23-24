package edu.project4.fractals.transformations;

import edu.project4.model.Point;
import static java.lang.Math.sin;

public class SinusTransform implements Transformation {

    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();

        return new Point(sin(x), sin(y));
    }
}
