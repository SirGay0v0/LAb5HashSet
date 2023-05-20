package commands;

import vehicle_types_coordinates.Vehicle;

import java.util.HashSet;

public interface minByEnginePower {
    static void minPower(HashSet<Vehicle> hashSet) {
        long minPower = 999999999;
        for (Vehicle min : hashSet) {
            if (min.getEnginePower() < minPower) {
                minPower = min.getEnginePower();
            }
        }
        for (Vehicle i : hashSet) {
            if (i.getEnginePower() == minPower) {
                System.out.println(i);
            }
        }
    }
}
