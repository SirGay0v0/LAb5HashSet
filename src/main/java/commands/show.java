package commands;

import java.util.HashSet;

public interface show {
    static void show(HashSet hashSet){
        for (Object vehicle: hashSet){
            System.out.println(vehicle.toString());
        }
    }
}
