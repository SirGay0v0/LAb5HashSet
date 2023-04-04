package commands;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public interface update {
    static void updateID(HashSet hashSet, Scanner sc) {
        boolean checkId = true;
        while (checkId) {
            try {
                System.out.println("Введите id элемента который хочется изменить:");
                int id = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Введите значение типа число.");
                sc.nextLine();
            }

        }
    }
}
