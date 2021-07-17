package PolymorphismLab.L02Shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.setRadius(radius);
        this.calculatePerimeter();
        this.calculateArea();
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return radius;
    }

    @Override
    public void calculatePerimeter() {
        setPerimeter(2 * Math.PI * radius);
    }

    @Override
    public void calculateArea() {
        setArea(Math.pow(radius, 2) * Math.PI);
    }
}
