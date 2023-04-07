package org.example;

import commands.*;
import vehicle_types_coordinates.Vehicle;

import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();
        HashSet<Vehicle> hashset = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        boolean work = true;
        while (work) {
            System.out.print("Напишите команду:");
            String choose = sc.nextLine();
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(choose);
            int id = 0;
            if (matcher.find()) {
                id = Integer.parseInt(matcher.group());
                choose = choose.replaceAll("\s\\d+", "");
            }
            switch (choose) {
                case "help" -> help.help();
                case "info" -> info.info(hashset, date);
                case "show" -> show.show(hashset);
                case "add" -> add.addVehicle(hashset, sc);
                case "update id" -> update.updateID(hashset, sc, id);
                case "remove_by_id" -> removeById.remove(hashset, id);
                case "clear" -> clear.clear(hashset);
                case "exit" -> work = false;
            }
        }
    }
}