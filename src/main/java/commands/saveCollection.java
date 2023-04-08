package commands;

import vehicle_types_coordinates.Vehicle;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.HashSet;

public interface saveCollection {
    static void save(HashSet<Vehicle> hashSet, Path path) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(path + "Collection.xml");
        writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        writer.println("<HashSet>");
        for (Vehicle vehicle : hashSet) {
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
    }
}
