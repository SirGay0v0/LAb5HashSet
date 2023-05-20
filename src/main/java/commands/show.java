package commands;

import java.util.HashSet;

public interface show {
    static void showCommand(HashSet hashSet){
        for (Object vehicle: hashSet){
            System.out.println(vehicle.toString());
        }
    }
}
