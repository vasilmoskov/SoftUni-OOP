package PolymorphismLab.L02Shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.setHeight(height);
        this.setWidth(width);
        this.calculateArea();
        this.calculatePerimeter();
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(2 * height * width);
    }

    @Override
    protected void calculateArea() {
        setArea(this.height * this.width);
    }
}
