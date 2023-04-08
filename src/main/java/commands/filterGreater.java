package commands;

import vehicle_types_coordinates.Vehicle;
import vehicle_types_coordinates.VehicleType;

import java.util.HashSet;

public interface filterGreater {
    static void filter(HashSet<Vehicle> hashSet, String Enum) {
        boolean check = true;
        while (check) {
            switch (Enum) {
                case "SPACESHIP" -> {
                    System.out.println("Объектов больше этого типа не найдено.");
                    check = false;
                }
                case "BOAT" -> {
                    for (Vehicle vehicle : hashSet) {
                        if (vehicle.getType() == VehicleType.SPACESHIP) {
                            System.out.println(vehicle);
                        }
                    }
                    check = false;
                }
                case "HOVERBOARD" -> {
                    for (Vehicle vehicle : hashSet) {
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
                    for (Vehicle vehicle : hashSet) {
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
                case "" -> {
                    for (Vehicle vehicle : hashSet) {
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
    }
}
