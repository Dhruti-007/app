import java.util.Scanner;

abstract class Shape {
    public abstract double calculateArea();
    public abstract void displayArea();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void displayArea() {
        System.out.println("Circle Area: " + calculateArea());
    }
}

class Rectangle extends Shape {
    private double length, breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double calculateArea() {
        return length * breadth;
    }

    @Override
    public void displayArea() {
        System.out.println("Rectangle Area: " + calculateArea());
    }
}

class Triangle extends Shape {
    private double base, height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public void displayArea() {
        System.out.println("Triangle Area: " + calculateArea());
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter radius of circle: ");
        double radius = sc.nextDouble();

        System.out.print("Enter length and breadth of rectangle: ");
        double length = sc.nextDouble();
        double breadth = sc.nextDouble();

        System.out.print("Enter base and height of triangle: ");
        double base = sc.nextDouble();
        double height = sc.nextDouble();

        Shape[] shapes = {
            new Circle(radius),
            new Rectangle(length, breadth),
            new Triangle(base, height)
        };

        for (Shape s : shapes) {
            s.displayArea(); // polymorphic call
        }
    }
}