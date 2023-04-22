package commands;

import vehicle_types_coordinates.*;

import java.time.LocalDateTime;
import java.util.*;

public interface updateID {

    static void updateID(HashSet<Vehicle> hashSet, Scanner sc, int id) {
        Vehicle newVehicle = new Vehicle();

        newVehicle.setId(id);

        boolean checkName = true;
        while (checkName) {
            System.out.print("Введите новое имя элемента: ");
            String name = sc.nextLine();
            if (!Objects.equals(name, "") && name != null) {
                newVehicle.setName(name, sc);
                checkName = false;
            }
        }

        boolean checkCoordinates = true;
        while (checkCoordinates) {
            try {
                System.out.print("Введите новую координату X элемента: ");
                float x;
                x = sc.nextFloat();
                sc.nextLine();
                System.out.print("Введите новую координату Y элемента: ");
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
            System.out.print("Введите новую мощность элемента: ");
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
            System.out.print("Введите новое кол-во колес у элемента: ");
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
            System.out.print("Введите новую вместимость элемента: ");
            try {
                long capacity = sc.nextLong();
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
            System.out.print("Выберите новый тип элемента(DRONE, BOAT, HOVERBOARD, SPACESHIP): ");
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
                case "" -> {
                    newVehicle.setType(null);
                    check = false;
                }
                default -> System.out.println("Введен неверный тип. Попробуйте еще раз.");
            }
        }
        hashSet.removeIf(deleteVehicle -> deleteVehicle.getId() == id);
        System.out.println("Элемент с ID - " + id + " был успешно обновлен.");
        hashSet.add(newVehicle);
    }
}
