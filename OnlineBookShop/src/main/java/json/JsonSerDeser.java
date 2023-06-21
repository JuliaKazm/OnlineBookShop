package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Customers;
import models.Orders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class JsonSerDeser {

    private static final Logger logger = LogManager.getLogger(JsonSerDeser.class);

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Serialize objects to JSON
            Customers customer1 = new Customers(1, "John", "Doe", "123 Main St", "john.doe@example.com");
            Orders order1 = new Orders(14, 1, "2023-05-30", "Pending");

            // Write objects to JSON file
            File customerFile = new File("/Users/j_mac/OnlineBookShop/OnlineBookShop/src/main/java/json/customers.json");
            objectMapper.writeValue(customerFile, customer1);
            logger.info("Customer serialized and written to JSON file.");

            File orderFile = new File("/Users/j_mac/OnlineBookShop/OnlineBookShop/src/main/java/json/orders.json");
            objectMapper.writeValue(orderFile, order1);
            logger.info("Order serialized and written to JSON file.");

            // Deserialize JSON back to objects
            Customers deserializedCustomer = objectMapper.readValue(customerFile, Customers.class);
            logger.info("Deserialized customer: " + deserializedCustomer);

            Orders deserializedOrder = objectMapper.readValue(orderFile, Orders.class);
            logger.info("Deserialized order: " + deserializedOrder);

        } catch (IOException e) {
            logger.error("An error occurred during JSON serialization or deserialization: " + e.getMessage());
        }
    }
}
