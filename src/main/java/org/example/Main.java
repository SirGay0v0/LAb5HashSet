package org.example;

import commands.*;
import vehicle_types_coordinates.Vehicle;
import xmlToCollection.XMLjdomReader;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {

        HashSet<Vehicle> hashset = new HashSet<>();
        Iterator<Vehicle> vehicleIterator = hashset.iterator();
        Date date = new Date();

        final String pathCollection = System.getenv("Proga_5_Lab_HashSet_Collection");
        final String pathScript = System.getenv("Proga_5_Lab_HashSet_Script");

        XMLjdomReader.xmlParser(hashset, Path.of(pathCollection));

        BufferedReader buff = new BufferedReader(new FileReader(pathCollection));

        Scanner sc = new Scanner(System.in);
        boolean work = true;
        while (work) {
            System.out.print("Напишите команду:");
            String choose = sc.nextLine();

            Pattern patternNumber = Pattern.compile("\\d+");
            Pattern patternEnum = Pattern.compile("[A-Z]*$");
            Pattern patternScript = Pattern.compile("^(execute_script)\s");

            Matcher matcherNumber = patternNumber.matcher(choose);
            Matcher matcherEnum = patternEnum.matcher(choose);
            Matcher matcherScript = patternScript.matcher(choose);

            int variableNumber = 0;
            String variableEnum = "";
            String variableScript = "";

            if (matcherNumber.find()) {
                variableNumber = Integer.parseInt(matcherNumber.group());
                choose = choose.replaceAll("\s\\d+", "");
            }
            if (matcherEnum.find()) {
                variableEnum = matcherEnum.group();
                choose = choose.replaceAll("\s[A-Z]*$", "");
            }
            if(matcherScript.find()){
                variableScript = choose.replaceAll("^(execute_script)\s", "");
                choose = choose.replaceAll("\s[\\d\\S]*$", "");
            }
            switch (choose) {
                case "help" -> help.help();
                case "info" -> info.info(hashset, date);
                case "show" -> show.show(hashset);
                case "add" -> add.addVehicle(hashset, sc);
                case "update id" -> updateID.updateID(hashset, sc, variableNumber);
                case "remove_by_id" -> removeById.remove(hashset, variableNumber);
                case "clear" -> clear.clear(hashset);
                case "save" -> saveCollection.save(hashset, Path.of(pathCollection));
                case "execute_script" -> executeScript.script(Path.of(pathScript), Path.of(pathCollection), variableScript, hashset, vehicleIterator,date);
                case "exit" -> work = false;
                case "add_if_max" -> addIfMax.addifmax(hashset, variableNumber);
                case "add_if_min" -> addIfMin.addifmin(hashset, variableNumber);
                case "remove_lower" -> removeLower.removelower(hashset, variableNumber);
                case "average_of_number_of_wheels" -> averageOfWheels.averagaWheels(hashset);
                case "min_by_engine_power" -> minByEnginePower.minPower(hashset);
                case "filter_greater_than_type" -> filterGreater.filter(hashset, variableEnum);

            }
        }
    }
}