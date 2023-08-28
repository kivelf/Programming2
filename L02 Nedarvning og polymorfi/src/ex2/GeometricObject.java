package ex2;

public abstract class GeometricObject {
    private double x;
    private double y;

    // the constructor is protected bc it's only used by the subclasses
    protected GeometricObject(){}

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setNewCoordinates(double a, double b) {
        setX(getX() + a);
        setY(getY() + b);
    }

    public abstract double getArea();
}
