package check_for_duplicates;

import vehicle_types_coordinates.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

public interface duplicates_remove {
    static void remove(HashSet<Vehicle> hashSet) {
        ArrayList<Vehicle> arrayList = new ArrayList<>();
        ArrayList<Vehicle> arrayListDeletedVehicles = new ArrayList<>();
        for (Vehicle i : hashSet) {
            arrayList.add(i);
        }

        for (Vehicle veh1 : arrayList) {
            long firstID = veh1.getId();
            int checkpoint = 0;
            for (Vehicle veh2 : arrayList) {
                long secondID = veh2.getId();
                if (firstID == secondID && checkpoint != 0) {
                    hashSet.remove(veh2);
                }

                if (firstID == secondID && checkpoint == 0) {
                    checkpoint++;
                }

            }
        }
    }
}
