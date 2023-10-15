package services;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.node.ObjectNode;
import entity.Customer;
import entity.Movie;
import entity.Rental;
import utils.Utils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ReadWriteService {

    private String filePath = "newFile.txt";
    private static ReadWriteService readWriteService = new ReadWriteService();
    private static Warehouse warehouse = Warehouse.getInstance();

    private ReadWriteService() {
    }

    public static ReadWriteService getInstance() {
        return readWriteService;
    }

    public void saveToFile() {
        File file = createFile();

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode parentObject = objectMapper.createObjectNode();
        parentObject.put("customer", objectMapper.valueToTree(warehouse.getAllCustomers()));
        parentObject.put("movie", objectMapper.valueToTree(warehouse.getAllMovies()));
        parentObject.put("rental", objectMapper.valueToTree(warehouse.getAllRentals()));

        try {
            objectMapper.writeValue(file, parentObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Utils.INFO_SAVED);
    }

    public void readFromFile() {
        try {
            File file = new File(filePath);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode parentObject = objectMapper.readTree(file);

            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            objectMapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));

            Customer[] customersArray = objectMapper.treeToValue(parentObject.get("customer"), Customer[].class);
            Movie[] movieArray = objectMapper.treeToValue(parentObject.get("movie"), Movie[].class);
            Rental[] rentalArray = objectMapper.treeToValue(parentObject.get("rental"), Rental[].class);

            Arrays.stream(customersArray).forEach(customer -> warehouse.saveToCustomers(customer));
            Arrays.stream(movieArray).forEach(movie -> warehouse.saveToMovies(movie));
            Arrays.stream(rentalArray).forEach(rental -> warehouse.saveToRentals(rental));

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Utils.INFO_READ);
    }

    private File createFile() {
        File file = null;
        try {
            file = new File(filePath);
            file.createNewFile();
        } catch (IOException e) {
        }
        return file;
    }
}
