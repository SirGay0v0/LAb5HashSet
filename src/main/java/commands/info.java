package commands;

import java.util.Date;
import java.util.HashSet;

public interface info {
    static void info(HashSet hashSet, Date date) {
        System.out.println("HashSet, " + date.toString() + ", " + hashSet.size());
    }
}
