package ex2;

public class Circle extends GeometricObject {
    private double radius;

    public Circle(double radius, double x, double y) {
        this.radius = radius;
        setX(x);
        setY(y);
    }

    @Override
    public void setNewCoordinates(double a, double b){
        setX(getX() + a);
        setY(getY() + b);
    }

    @Override
    public double getArea(){
        return radius * radius * Math.PI;
    }

    @Override
    public String toString(){
        return "Circle with radius " + radius + ", coordinates x: " + getX() + ", y: " + getY();
    }
}
