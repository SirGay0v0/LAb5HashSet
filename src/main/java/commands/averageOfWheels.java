package commands;

import vehicle_types_coordinates.Vehicle;

import java.util.HashSet;

public interface averageOfWheels {

    static void averagaWheels(HashSet<Vehicle> hashSet) {

        float allWheels = 0, countOfWheels = 0, averaga = 0;

        for (Vehicle vehicle : hashSet) {
            countOfWheels++;
            allWheels = allWheels + vehicle.getNumberOfWheels();
        }
        averaga = allWheels / countOfWheels;

        System.out.println("Среднее количество колес: " + averaga);
    }
}

