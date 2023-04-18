package Lambdas.model;

import java.util.List;

public interface Shape {
    double calcSquare();

    // посчитать сумму
    static double calcShapeSquare(List<Shape> shapes) {
        double squareSum = 0;
        for (Shape shape : shapes) {
            squareSum = squareSum + shape.calcSquare();
        }
        return squareSum;
    }

    default double calcSomething() {
        return 1;
    }
}
