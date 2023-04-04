package org.example;

import commands.*;
import vehicle_types_coordinates.Vehicle;

import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();
        HashSet<Vehicle> hashset = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        boolean work = true;
        while (work) {
            System.out.print("Напишите команду:");
            String choose = sc.nextLine();
            switch(choose){
                case "help" -> help.help();
                case "info" -> info.info(hashset, date);
                case "show" -> show.show(hashset);
                case "add" -> add.addVehicle(hashset,sc);
                case "exit" -> work = false;
            }
        }
    }
}