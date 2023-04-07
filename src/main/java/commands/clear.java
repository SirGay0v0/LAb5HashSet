package commands;

import java.util.HashSet;

public interface clear {
    static void clear(HashSet hashSet){
        hashSet.removeAll(hashSet);
    }
}
