package opg5;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new Car("Citroen", "C3", 2019, 73501.6, 5);
        Vehicle v2 = new Motorcycle("Yamaha", "MT-09", 2022, 13645.2, 890);
        Vehicle v3 = new Truck("Scania", "R-Series", 2016, 358295.4, 39.7);

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(v1);
        vehicles.add(v2);
        vehicles.add(v3);

        printVehicleInfo(vehicles);
        doVehicleActions(vehicles);
    }

    public static void printVehicleInfo(ArrayList<Vehicle> list){
        for (Vehicle v : list){
            v.displayInfo();
        }
    }

    public static void doVehicleActions(ArrayList<Vehicle> list){
        for (Vehicle v : list){
            v.start();
            v.action();
            v.stop();
            System.out.println();
        }
    }
}
