package commands;

import vehicle_types_coordinates.Coordinates;
import vehicle_types_coordinates.Vehicle;
import vehicle_types_coordinates.VehicleType;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public interface add {
    static void addVehicle(HashSet<Vehicle> hashset, Scanner sc) {
        Vehicle newVehicle = new Vehicle();

        long id = (long) (Math.random() * 1000);
        newVehicle.setId(id);

        boolean checkName = true;
        while (checkName) {
            System.out.print("Введите имя добавляемого элемента: ");
            String name = sc.nextLine();
            if (!Objects.equals(name, "") && name != null) {
                newVehicle.setName(name, sc);
                checkName = false;
            }
        }

        boolean checkCoordinates = true;
        while (checkCoordinates) {
            try {
                System.out.print("Введите координату X добавляемого элемента: ");
                float x;
                x = sc.nextFloat();
                sc.nextLine();
                System.out.print("Введите координату Y добавляемого элемента: ");
                int y = sc.nextInt();
                newVehicle.setCoordinates(new Coordinates(x, y));
                checkCoordinates = false;
            } catch (InputMismatchException e) {
                System.out.println("Введите значение типа число.");
                sc.nextLine();
            }
        }


        LocalDateTime creationDate = LocalDateTime.now();
        newVehicle.setCreationDate(creationDate);

        boolean checkEngine = true;
        while (checkEngine) {
            System.out.print("Введите мощность добавляемого элемента: ");
            try {
                long engine = sc.nextLong();
                if (engine > 0) {
                    newVehicle.setEnginePower(engine);
                    checkEngine = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Введите значение типа число.");
                sc.nextLine();
            }
        }
        boolean checkWheels = true;
        while (checkWheels) {
            System.out.print("Введите кол-во колес у добавляемого элемента: ");
            try {
                long wheels = sc.nextLong();
                sc.nextLine();
                if (wheels > 0) {
                    newVehicle.setNumberOfWheels(wheels);
                    checkWheels = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Введите значение типа число.");
                sc.nextLine();
            }
        }

        boolean checkCapacity = true;
        while (checkCapacity) {
            System.out.print("Введите вместимость добавляемого элемента: ");
            try {
                int capacity = sc.nextInt();
                sc.nextLine();
                if (capacity > 0) {
                    newVehicle.setCapacity(capacity);
                    checkCapacity = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Введите значение типа число.");
                sc.nextLine();
            }
        }

        boolean check = true;
        while (check) {
            System.out.print("Выберите тип добавляемого элемента(DRONE, BOAT, HOVERBOARD, SPACESHIP): ");
            String choice = sc.nextLine();
            switch (choice) {
                case "DRONE" -> {
                    newVehicle.setType(VehicleType.DRONE);
                    check = false;
                }
                case "BOAT" -> {
                    newVehicle.setType(VehicleType.BOAT);
                    check = false;
                }
                case "HOVERBOARDE" -> {
                    newVehicle.setType(VehicleType.HOVERBOARD);
                    check = false;
                }
                case "SPACESHIP" -> {
                    newVehicle.setType(VehicleType.SPACESHIP);
                    check = false;
                }
                case "null" -> {
                    newVehicle.setType(null);
                    check = false;
                }
                default -> System.out.println("Введен неверный тип. Попробуйте еще раз.");
            }
        }
        System.out.println("Элемент был успешно добавлен.");
        hashset.add(newVehicle);
    }
}

