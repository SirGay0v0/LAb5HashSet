package commands;

import vehicle_types_coordinates.Vehicle;

import java.util.HashSet;
import java.util.Scanner;

public interface addIfMax {
    static void addifmax(HashSet<Vehicle> hashSet, int maxCapacity) {
        float maxCapacityHashset = 0;
        for (Vehicle max : hashSet) {
            if (max.getCapacity() > maxCapacityHashset) {
                maxCapacityHashset = max.getCapacity();
            }
        }

        if (maxCapacity > maxCapacityHashset) {
            add.addVehicle(hashSet, new Scanner(System.in));
        } else {
            System.out.println("В коллекции есть объект побольше.");
        }
    }
}
