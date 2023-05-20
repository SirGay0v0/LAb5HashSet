package xmlToCollection;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.DOMBuilder;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.StAXEventBuilder;
import org.jdom2.input.StAXStreamBuilder;
import org.xml.sax.SAXException;
import vehicle_types_coordinates.Coordinates;
import vehicle_types_coordinates.Vehicle;
import vehicle_types_coordinates.VehicleType;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public interface XMLjdomReader {
     static void xmlParser(HashSet<Vehicle> hashSet, String path) {
        String filename = String.valueOf(path);
        try {
            // мы можем создать экземпляр JDOM Document из классов DOM, SAX и STAX Builder
            org.jdom2.Document jdomDocument = createJDOMusingDOMParser(filename);
            Element root = jdomDocument.getRootElement();
            // получаем список всех элементов Vehicle
            List<Element> vehListElement = root.getChildren("Vehicle");
            // список объектов Vehicle, в которых будем хранить
            // считанные данные по каждому элементу
            List<Vehicle> vehicles = new ArrayList<>();
            for (Element vehicleEL : vehListElement) {
                Vehicle vehicle = new Vehicle();

                vehicle.setId(Integer.parseInt(vehicleEL.getChildText("id")));

                vehicle.setName(vehicleEL.getChildText("name"));

                String x = String.valueOf(vehicleEL.getChild("coordinates").getChildText("x"));
                String y = String.valueOf(vehicleEL.getChild("coordinates").getChildText("y"));
                vehicle.setCoordinates(new Coordinates(Float.parseFloat(x), Integer.parseInt(y)));

                vehicle.setCreationDate(LocalDateTime.parse(vehicleEL.getChildText("creationDate")));

                vehicle.setEnginePower(Long.parseLong(vehicleEL.getChildText("enginePower")));

                vehicle.setNumberOfWheels(Long.parseLong(vehicleEL.getChildText("numberOfWheels")));

                vehicle.setCapacity(Integer.parseInt(vehicleEL.getChildText("capacity")));

                vehicle.setType(VehicleType.valueOf(vehicleEL.getChildText("VehicleType")));

                vehicles.add(vehicle);
            }
            // печатаем полученный список объектов Vehicle
            for (Vehicle vehicle : vehicles) {
                hashSet.add(vehicle);
            }
        } catch (Exception e) {
            System.out.println("Запрашиваемый XML файл отсутствует, либо он поврежден.");
        }

    }


    // получаем экземпляр JDOM Document с помощью DOM Parser
    private static org.jdom2.Document createJDOMusingDOMParser(String fileName)
            throws ParserConfigurationException, SAXException, IOException {
        //создаем DOM Document
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        documentBuilder = dbFactory.newDocumentBuilder();
        org.w3c.dom.Document doc = documentBuilder.parse(new File(fileName));
        DOMBuilder domBuilder = new DOMBuilder();

        return domBuilder.build(doc);

    }

    // получаем экземпляр JDOM Document с помощью SAX Parser
    private static org.jdom2.Document createJDOMusingSAXParser(String fileName)
            throws JDOMException, IOException {
        SAXBuilder saxBuilder = new SAXBuilder();
        return saxBuilder.build(new File(fileName));
    }

    // получаем экземпляр JDOM Document с помощью STAX Stream Parser или STAX Event Parser
    private static org.jdom2.Document createJDOMusingSTAXParser(String fileName, String type)
            throws FileNotFoundException, XMLStreamException, JDOMException {
        if (type.equalsIgnoreCase("stream")) {
            StAXStreamBuilder staxBuilder = new StAXStreamBuilder();
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLStreamReader xmlStreamReader =
                    xmlInputFactory.createXMLStreamReader(new FileInputStream(fileName));
            return staxBuilder.build(xmlStreamReader);
        }
        StAXEventBuilder staxBuilder = new StAXEventBuilder();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(
                new FileInputStream(fileName));
        return staxBuilder.build(xmlEventReader);

    }
}