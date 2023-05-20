package commands;

import vehicle_types_coordinates.Vehicle;

import java.util.HashSet;

public interface removeLower {
    static void removelower(HashSet<Vehicle> hashSet, float minCapacityLine) {

        hashSet.removeIf(min -> min.getCapacity() < minCapacityLine);
        System.out.println("Все элементы меньше заданного значения были успешно удалены.");
    }
}
