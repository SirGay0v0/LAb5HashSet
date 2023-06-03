package org.example;

import check_for_duplicates.duplicates_remove;
import commands.*;
import vehicle_types_coordinates.Vehicle;
import xmlToCollection.XMLjdomReader;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author SirGay
 * @version final
 */
public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * @link Объявление составляющих
         */
        HashSet<Vehicle> hashset = new HashSet<>();
        Date date = new Date();

        final String pathCollection = System.getenv("Proga_5_Lab_HashSet_Collection");
        final String pathScript = System.getenv("Proga_5_Lab_HashSet_Script");
/**
 * @link перенос из xml в коллекцию
 */
        XMLjdomReader.xmlParser(hashset, pathCollection);

        duplicates_remove.remove(hashset);
        saveCollection.save(hashset, pathCollection);
        System.out.println("Все элементы были обновлены до их последней модификации.");

        Scanner sc = new Scanner(System.in);
        boolean work = true;
        boolean defender = false;
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
            if (matcherScript.find()) {
                variableScript = choose.replaceAll("^(execute_script)\s", "");
                choose = choose.replaceAll("\s[\\d\\S]*$", "");
            }
            /**
             * @link список всех команд
             */
            switch (choose) {
                case "help" -> help.helpCommands();
                case "info" -> info.infoCommand(hashset, date);
                case "show" -> show.showCommand(hashset);
                case "add" -> add.addVehicle(hashset, sc);
                case "update id" -> updateID.updateIDCommand(hashset, sc, variableNumber);
                case "remove_by_id" -> removeById.remove(hashset, variableNumber);
                case "clear" -> clear.clearCollection(hashset);
                case "save" -> saveCollection.save(hashset, pathCollection);
                case "execute_script" ->
                        executeScript.script(Path.of(pathScript), Path.of(pathCollection), variableScript, hashset, date, defender);
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