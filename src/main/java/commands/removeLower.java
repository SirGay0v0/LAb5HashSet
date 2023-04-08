package commands;

import vehicle_types_coordinates.Vehicle;

import java.util.HashSet;

public interface removeLower {
    static void removelower(HashSet<Vehicle> hashSet, float minCapacityLine) {

        for (Vehicle min : hashSet) {
            if (min.getCapacity() < minCapacityLine) {
                hashSet.remove(min);
            }
        }
        System.out.println("Все элементы меньше заданного значения были успешно удалены.");
    }
}
