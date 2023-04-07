package commands;

import vehicle_types_coordinates.Vehicle;

import java.util.HashSet;

public interface removeById {
    static void remove(HashSet<Vehicle> hashSet, int id) {
        Vehicle vehicle = new Vehicle();
        for (Vehicle delete : hashSet) {
            if (delete.getId() == id) {
                hashSet.remove(delete);
            }
        }
    }
}
