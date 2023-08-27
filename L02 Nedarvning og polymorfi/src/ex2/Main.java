package ex2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GeometricObject g1 = new Circle(5, 2, 3);
        GeometricObject g2 = new Ellipse(2, 4, 5, 18);
        GeometricObject g3 = new Rectangle(12.5, 4.5, 3, 5.67);
        GeometricObject g4 = new Square(8, -55, -16);

        ArrayList<GeometricObject> geometricObjects = new ArrayList<>();
        geometricObjects.add(g1);
        geometricObjects.add(g2);
        geometricObjects.add(g3);
        geometricObjects.add(g4);

        printFigures(geometricObjects);
        System.out.println();

        // moving the x-coordinate of all figures by -5.2 and the y-coordinate by +10
        moveAllFigures(geometricObjects, -5.2, 10);
        printFigures(geometricObjects);
        System.out.println();

        printArea(geometricObjects);
        System.out.println();

        printTotalArea(geometricObjects);
    }

    public static void printFigures(ArrayList<GeometricObject> figures){
        for (GeometricObject f : figures){
            System.out.println(f);
        }
    }

    public static void moveAllFigures(ArrayList<GeometricObject> figures, double a, double b){
        for (int i = 0; i < figures.size(); i++){
            // moving all figures' x-coordinate by a and y-coordinate by b
            figures.get(i).setNewCoordinates(a, b);
        }
    }

    public static void printArea(ArrayList<GeometricObject> figures){
        for (GeometricObject f : figures){
            System.out.println("The area of the figure is: " + f.getArea() + " cm^3");
        }
    }

    public static void printTotalArea(ArrayList<GeometricObject> figures){
        double total = 0;
        for (GeometricObject f : figures){
            total += f.getArea();
        }
        System.out.println("The total area of all figures is " + total + " cm^3");
    }
}
