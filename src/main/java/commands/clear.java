package commands;

import org.w3c.dom.ls.LSOutput;

import java.util.HashSet;

public interface clear {
    static void clear(HashSet hashSet){
        hashSet.removeAll(hashSet);

        System.out.println("Все элементы были успешно удалены из коллекции.");
    }
}
