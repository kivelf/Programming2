package ex2;

public class Ellipse extends GeometricObject {
    private double r1;
    private double r2;

    public Ellipse(double r1, double r2, double x, double y) {
        this.r1 = r1;
        this.r2 = r2;
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
        return r1 * r2 * Math.PI;
    }

    @Override
    public String toString(){
        return "Ellipse with axis a: " + r1 + ", axis b: " + r2 + ", coordinates x: " + getX() + ", y: " + getY();
    }
}
