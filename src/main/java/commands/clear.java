package commands;

import java.util.HashSet;

public interface clear {
    static void clearCollection(HashSet hashSet){
        hashSet.removeAll(hashSet);

        System.out.println("Все элементы были успешно удалены из коллекции.");
    }
}

