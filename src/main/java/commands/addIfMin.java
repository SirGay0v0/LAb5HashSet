package commands;

import vehicle_types_coordinates.Vehicle;

import java.util.HashSet;
import java.util.Scanner;

public interface addIfMin {
    static void addifmin(HashSet<Vehicle> hashSet, int minCapacity) {
        float minCapacityHashset = 999999999;
        for (Vehicle min : hashSet) {
            if (min.getCapacity() < minCapacityHashset) {
                minCapacityHashset = min.getCapacity();
            }
        }

        if (minCapacity < minCapacityHashset) {
            add.addVehicle(hashSet, new Scanner(System.in));
        } else {
            System.out.println("В коллекции есть объект поменьше.");
        }
    }
}
