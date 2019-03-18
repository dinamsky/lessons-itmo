package com.ifmo.lessons.shapes;

public class Rectangle extends shape {
    private Point a, b;

    public Rectangle(Point a, Point b) throws CloneNotSupportedException {
        setRectangle(a, b);
    }

    public void setRectangle(Point a, Point b) throws CloneNotSupportedException {
        this.a = a.clone();
        this.b = b.clone();
    }


    @Override
    public double getArea() {
        Point z = a.squareProjection(b);
        return a.distance(z) * b.distance(z);
    }

    @Override
    public double getPerimeter() {
        Point z = a.squareProjection(b);
        return 2 * (a.distance(z) + b.distance(z));
    }
}
