package com.ifmo.lessons.shapes;

public class Circle extends shape {

    private Point center;
    private double radius;
    public Circle(Point a, double r) throws CloneNotSupportedException {
        setCircle (a,r);
    }
    public void setCircle (Point a, double r) throws CloneNotSupportedException{
        this.center = a.clone();
        this.radius = r;

    }


    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}