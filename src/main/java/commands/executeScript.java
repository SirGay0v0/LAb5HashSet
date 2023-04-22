package commands;

import vehicle_types_coordinates.Coordinates;
import vehicle_types_coordinates.Vehicle;
import vehicle_types_coordinates.VehicleType;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.temporal.ValueRange;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface executeScript {
    static void script(Path pathScript, Path pathCollection, String scriptName, HashSet<Vehicle> hashset, Iterator<Vehicle> iterator,Date date) throws IOException {

        String fileName = pathScript + "\\" + scriptName;
        BufferedReader buff = new BufferedReader(new FileReader(fileName));
        String line;

        Pattern patternNumber = Pattern.compile("\\d+");
        Pattern patternEnum = Pattern.compile("[A-Z]*$");
        Pattern patternScript = Pattern.compile("^(execute_script)\s");

        int variableNumber = 0;
        String variableEnum = "";
        String variableScript = "";

        while (!((line = buff.readLine()).equals("exit"))) {


            Matcher matcherNumber = patternNumber.matcher(line);
            Matcher matcherEnum = patternEnum.matcher(line);
            Matcher matcherScript = patternScript.matcher(line);


            if (matcherNumber.find()) {
                variableNumber = Integer.parseInt(matcherNumber.group());
                line = line.replaceAll("\s\\d+", "");
            }
            if (matcherEnum.find()) {
                variableEnum = matcherEnum.group();
                line = line.replaceAll("\s[A-Z]*$", "");
            }
            if (matcherScript.find()) {
                variableScript = line.replaceAll("^(execute_script)\s", "");
                line = line.replaceAll("\\s[\\d\\S]*$", "");
            }

            switch (line) {
                case "help":
                    help.help();
                    System.out.println();
                    break;
                case "info":
                    info.info(hashset, date);
                    System.out.println();
                    break;
                case "show":
                    show.show(hashset);
                    System.out.println();
                    break;
                case "add":
                    Vehicle addVehicle = new Vehicle();
                    long id = (long) (Math.random() * 1000);
                    addVehicle.setId(id);
                    addVehicle.setName(buff.readLine());
                    float addX = Float.parseFloat(buff.readLine());
                    int addY = Integer.parseInt(buff.readLine());
                    addVehicle.setCoordinates(new Coordinates(addX, addY));
                    LocalDateTime addCreationDate = LocalDateTime.now();
                    addVehicle.setCreationDate(addCreationDate);
                    addVehicle.setEnginePower(Long.parseLong(buff.readLine()));
                    addVehicle.setNumberOfWheels(Long.parseLong(buff.readLine()));
                    addVehicle.setCapacity(Float.parseFloat(buff.readLine()));
                    addVehicle.setType(VehicleType.valueOf(buff.readLine()));
                    hashset.add(addVehicle);
                    System.out.println("Элемент был успешно добавлен.");
                    System.out.println();
                    break;
                case "update id":
                    Vehicle updateVehicle = new Vehicle();
                    updateVehicle.setId(variableNumber);
                    updateVehicle.setName(buff.readLine());
                    float updateX = Float.parseFloat(buff.readLine());
                    int updateY = Integer.parseInt(buff.readLine());
                    updateVehicle.setCoordinates(new Coordinates(updateX, updateY));
                    LocalDateTime creationDate = LocalDateTime.now();
                    updateVehicle.setCreationDate(creationDate);
                    updateVehicle.setEnginePower(Long.parseLong(buff.readLine()));
                    updateVehicle.setNumberOfWheels(Long.parseLong(buff.readLine()));
                    updateVehicle.setCapacity(Float.parseFloat(buff.readLine()));
                    updateVehicle.setType(VehicleType.valueOf(buff.readLine()));
                    int minID = variableNumber;
                    hashset.removeIf(a -> (a.getId() < minID));
                    hashset.add(updateVehicle);
                    System.out.println("Элемент с ID - " + variableNumber + " был успешно обновлен.");
                    System.out.println();
                    break;
                case "remove_by_id":
                    int deleteID = variableNumber;
                    hashset.removeIf(a -> (a.getId() < deleteID));
                    System.out.println("Элемент с ID - " + variableNumber+ " был успешно удален из коллекции.");
                    break;
                case "clear":
                    String deleteName = "sdfukgbsghbuk";
                    hashset.removeIf(a -> (a.getName() != deleteName));
                    break;
                case "save":
                    PrintWriter writer = new PrintWriter(String.valueOf(pathCollection));
                    writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
                    writer.println("<HashSet>");
                    for (Vehicle vehicle : hashset) {
                        writer.println("    <Vehicle>");
                        writer.println("        <id>" + vehicle.getId() + "</id>");
                        writer.println("        <name>" + vehicle.getName() + "</name>");
                        writer.println("        <coordinates>");
                        writer.println("            <x>" + vehicle.getCoordinates().getX() + "</x>");
                        writer.println("            <y>" + vehicle.getCoordinates().getY() + "</y>");
                        writer.println("        </coordinates>");
                        writer.println("        <creationDate>" + vehicle.getCreationDate() + "</creationDate>");
                        writer.println("        <enginePower>" + vehicle.getEnginePower() + "</enginePower>");
                        writer.println("        <numberOfWheels>" + vehicle.getNumberOfWheels() + "</numberOfWheels>");
                        writer.println("        <capacity>" + vehicle.getCapacity() + "</capacity>");
                        writer.println("        <VehicleType>" + vehicle.getType() + "</VehicleType>");
                        writer.println("    </Vehicle>");
                    }
                    writer.println("</HashSet>");
                    writer.close();
                    break;
                case "add_if_max":
                    float maxCapacityHashset = 0;
                    for (Vehicle max : hashset) {
                        if (max.getCapacity() > maxCapacityHashset) {
                            maxCapacityHashset = max.getCapacity();
                        }
                    }

                    if (variableNumber > maxCapacityHashset) {
                        Vehicle vehicleMaxCapacity = new Vehicle();
                        long idMaxCapacity = (long) (Math.random() * 1000);
                        vehicleMaxCapacity.setId(idMaxCapacity);
                        vehicleMaxCapacity.setName(buff.readLine());
                        float addXMaxCapacity = Float.parseFloat(buff.readLine());
                        int addYMaxCapacity = Integer.parseInt(buff.readLine());
                        vehicleMaxCapacity.setCoordinates(new Coordinates(addXMaxCapacity, addYMaxCapacity));
                        LocalDateTime addCreationDateMax = LocalDateTime.now();
                        vehicleMaxCapacity.setCreationDate(addCreationDateMax);
                        vehicleMaxCapacity.setEnginePower(Long.parseLong(buff.readLine()));
                        vehicleMaxCapacity.setNumberOfWheels(Long.parseLong(buff.readLine()));
                        vehicleMaxCapacity.setCapacity(Float.parseFloat(buff.readLine()));
                        vehicleMaxCapacity.setType(VehicleType.valueOf(buff.readLine()));
                        hashset.add(vehicleMaxCapacity);
                        System.out.println("Элемент был успешно добавлен.");
                        System.out.println();
                    } else {
                        System.out.println("В коллекции есть объект побольше.");
                        buff.readLine();buff.readLine();buff.readLine();buff.readLine();buff.readLine();buff.readLine();buff.readLine();
                    }
                    break;
                case "add_if_min":
                    float minCapacityHashset = 999999999;
                    for (Vehicle min : hashset) {
                        if (min.getCapacity() < minCapacityHashset) {
                            minCapacityHashset = min.getCapacity();
                        }
                    }

                    if (minCapacityHashset < variableNumber) {
                        Vehicle vehicleMinCapacity = new Vehicle();
                        long idMinCapacity = (long) (Math.random() * 1000);
                        vehicleMinCapacity.setId(idMinCapacity);
                        vehicleMinCapacity.setName(buff.readLine());
                        float addXMinCapacity = Float.parseFloat(buff.readLine());
                        int addYMinCapacity = Integer.parseInt(buff.readLine());
                        vehicleMinCapacity.setCoordinates(new Coordinates(addXMinCapacity, addYMinCapacity));
                        LocalDateTime addCreationDateMin = LocalDateTime.now();
                        vehicleMinCapacity.setCreationDate(addCreationDateMin);
                        vehicleMinCapacity.setEnginePower(Long.parseLong(buff.readLine()));
                        vehicleMinCapacity.setNumberOfWheels(Long.parseLong(buff.readLine()));
                        vehicleMinCapacity.setCapacity(Float.parseFloat(buff.readLine()));
                        vehicleMinCapacity.setType(VehicleType.valueOf(buff.readLine()));
                        hashset.add(vehicleMinCapacity);
                        System.out.println("Элемент был успешно добавлен.");
                        System.out.println();
                    } else {
                        System.out.println("В коллекции есть объект поменьше.");
                        buff.readLine();buff.readLine();buff.readLine();buff.readLine();buff.readLine();buff.readLine();buff.readLine();
                    }
                    break;
                case "remove_lower":
                    int deleteAll = variableNumber;
                        hashset.removeIf(a -> (a.getCapacity() < deleteAll));

                    System.out.println("Все элементы меньше заданного значения были успешно удалены.");
                    break;
                case "average_of_number_of_wheels":
                    float allWheels = 0, countOfWheels = 0, averaga = 0;

                    for (Vehicle vehicle : hashset) {
                        countOfWheels++;
                        allWheels = allWheels + vehicle.getNumberOfWheels();
                    }
                    averaga = allWheels / countOfWheels;

                    System.out.println("Среднее количество колес: " + averaga);
                    break;
                case "min_by_engine_power":
                    long minPower = 999999999;
                    for (Vehicle min : hashset) {
                        if (min.getEnginePower() < minPower) {
                            minPower = min.getEnginePower();
                        }
                    }
                    for (Vehicle i : hashset) {
                        if (i.getEnginePower() == minPower) {
                            System.out.println(i.toString());
                        }
                    }
                    break;
                case "filter_greater_than_type":
                    boolean check = true;
                    while (check) {
                        switch (variableEnum) {
                            case "SPACESHIP" -> {
                                System.out.println("Объектов больше этого типа не найдено.");
                                check = false;
                            }
                            case "BOAT" -> {
                                for (Vehicle vehicle : hashset) {
                                    if (vehicle.getType() == VehicleType.SPACESHIP) {
                                        System.out.println(vehicle);
                                    }
                                }
                                check = false;
                            }
                            case "HOVERBOARD" -> {
                                for (Vehicle vehicle : hashset) {
                                    if (vehicle.getType() == VehicleType.SPACESHIP) {
                                        System.out.println(vehicle);
                                    }
                                    if (vehicle.getType() == VehicleType.BOAT) {
                                        System.out.println(vehicle);
                                    }
                                }
                                check = false;
                            }
                            case "DRONE" -> {
                                for (Vehicle vehicle : hashset) {
                                    if (vehicle.getType() == VehicleType.SPACESHIP) {
                                        System.out.println(vehicle);
                                    }
                                    if (vehicle.getType() == VehicleType.BOAT) {
                                        System.out.println(vehicle);
                                    }
                                    if (vehicle.getType() == VehicleType.HOVERBOARD) {
                                        System.out.println(vehicle);
                                    }
                                }
                                check = false;
                            }
                            default -> {
                                for (Vehicle vehicle : hashset) {
                                    if (vehicle.getType() == VehicleType.SPACESHIP) {
                                        System.out.println(vehicle);
                                    }
                                    if (vehicle.getType() == VehicleType.BOAT) {
                                        System.out.println(vehicle);
                                    }
                                    if (vehicle.getType() == VehicleType.HOVERBOARD) {
                                        System.out.println(vehicle);
                                    }
                                    if (vehicle.getType() == VehicleType.DRONE) {
                                        System.out.println(vehicle);
                                    }
                                }
                                check = false;
                            }
                        }
                    }
                    break;
                case "":
                default:
                    break;
            }
        }
    }
}
