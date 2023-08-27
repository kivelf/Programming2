package ex2;

public class Rectangle extends GeometricObject {
    private double width;
    private double height;

    public Rectangle(double width, double height, double x, double y) {
        this.width = width;
        this.height = height;
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
        return width * height;
    }

    @Override
    public String toString(){
        return "Rectangle with width: " + width + ", height: " + height + ", coordinates x: " + getX() + ", y: " + getY();
    }
}
