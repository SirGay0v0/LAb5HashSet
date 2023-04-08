package org.example;

import commands.*;
import vehicle_types_coordinates.Vehicle;

import javax.sound.sampled.Line;
import java.io.*;
import java.nio.Buffer;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {

        HashSet<Vehicle> hashset = new HashSet<>();
        Date date = new Date();

        final String path = System.getenv("Proga_5_Lab_HashSet");

        BufferedReader buff = new BufferedReader(new FileReader(path + "Collection.xml"));

        String line, wrongLine;
        ArrayList<String> array = new ArrayList<>();


        Pattern pattern = Pattern.compile(">[a-zA-Z0-9.:-]*<");
        while (!(line = buff.readLine()).equals("</HashSet>")) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {

                wrongLine = matcher.group(Integer.toString(Integer.parseInt(line)));
                wrongLine = Arrays.toString(wrongLine.split("[><]"));
                array.add(wrongLine);
                System.out.println(array);
            }
        }


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
                case "save" -> saveCollection.save(hashset, Path.of(path));

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