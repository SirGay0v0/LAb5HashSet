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
            Pattern patternNumber = Pattern.compile("\\d+");
            Pattern patternEnum = Pattern.compile("[A-Z]*$");
            Matcher matcherNumber = patternNumber.matcher(choose);
            Matcher matcherEnum = patternEnum.matcher(choose);
            int peremennayaNumber = 0;
            String peremennayaEnum = "";
            if (matcherNumber.find()) {
                peremennayaNumber = Integer.parseInt(matcherNumber.group());
                choose = choose.replaceAll("\s\\d+", "");
            }
            if (matcherEnum.find()) {
                peremennayaEnum = matcherEnum.group();
            }
            switch (choose) {
                case "help" -> help.help();
                case "info" -> info.info(hashset, date);
                case "show" -> show.show(hashset);
                case "add" -> add.addVehicle(hashset, sc);
                case "update id" -> update.updateID(hashset, sc, peremennayaNumber);
                case "remove_by_id" -> removeById.remove(hashset, peremennayaNumber);
                case "clear" -> clear.clear(hashset);


                case "exit" -> work = false;
                case "add_if_max" -> addIfMax.addifmax(hashset, peremennayaNumber);
                case "add_if_min" -> addIfMin.addifmin(hashset, peremennayaNumber);
                case "remove_lower" -> removeLower.removelower(hashset, peremennayaNumber);
                case "average_of_number_of_wheels" -> averageOfWheels.averagaWheels(hashset);
                case "min_by_engine_power" -> minByEnginePower.minPower(hashset);
                case "filter_greater_than_type" -> filterGreater.filter(hashset, peremennayaEnum);

            }
        }
    }
}