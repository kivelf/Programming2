package ex2;

public class Square extends GeometricObject {
    private double side;

    public Square (double side, double x, double y) {
        this.side = side;
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
        return side * side;
    }

    @Override
    public String toString(){
        return "Square with side: " + side + ", coordinates x: " + getX() + ", y: " + getY();
    }
}
