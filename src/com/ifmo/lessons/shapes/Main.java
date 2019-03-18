package com.ifmo.lessons.shapes;

public class Main {
    public static void main (String[] args) throws CloneNotSupportedException {
        Triangle triangle = new Triangle(new Point(1,1), new Point(1,4), new Point(5,1));
        System.out.println("Периметр треугольника: " + triangle.getPerimeter());
        System.out.println("Площадь треугольника: " + triangle.getArea());

        Rectangle rectangle = new Rectangle(new Point(1,1), new Point(3,3));
        System.out.println("Периметр прямоугольника: " + rectangle.getPerimeter());
        System.out.println("Площадь прямоугольника: " + rectangle.getArea());

        Circle circle = new Circle(new Point(0,0), 10);
        System.out.println("Периметр круга: " + circle.getPerimeter());
        System.out.println("Площадь круга: " + circle.getArea());
    }
}
