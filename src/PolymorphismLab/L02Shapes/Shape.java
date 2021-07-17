package PolymorphismLab.L02Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    public Double getArea() {
        return area;
    }

    protected void setArea(Double area) {
        this.area = area;
    }

    public Double getPerimeter() {
        return perimeter;
    }

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    protected abstract void calculatePerimeter();

    protected abstract void calculateArea();
}
