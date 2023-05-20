package commands;

import vehicle_types_coordinates.Vehicle;

import java.util.HashSet;

public interface averageOfWheels {

    static void averagaWheels(HashSet<Vehicle> hashSet) {

        float allWheels = 0, countOfWheels = 0, average;

        for (Vehicle vehicle : hashSet) {
            countOfWheels++;
            allWheels = allWheels + vehicle.getNumberOfWheels();
        }
        average = allWheels / countOfWheels;

        System.out.println("Среднее количество колес: " + average);
    }
}

