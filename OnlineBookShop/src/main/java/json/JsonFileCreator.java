package json;
import models.Orders;
import models.Customers;
import models.OrderItems;
import models.Payments;
import models.Discounts;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class JsonFileCreator {

    private static final Logger logger = LogManager.getLogger(JsonFileCreator.class);

    public static void main(String[] args) {

        Customers customer1 = new Customers(1, "John", "Doe", "123 Main St", "john.doe@example.com");
        Orders order1 = new Orders(14, 7, "2023-06-12", "Pending");
        OrderItems orderItem1 = new OrderItems(11, 12, 7, 3, 5.99);
        Payments payment1 = new Payments(14, 3, 15, 23.67, "2023-06-11");
        Discounts discount1 = new Discounts(4, "25OFF", 25.00, 4);


        ObjectMapper objectMapper = new ObjectMapper();

        try {

            String customerJson = objectMapper.writeValueAsString(customer1);
            String orderJson = objectMapper.writeValueAsString(order1);
            String orderItemJson = objectMapper.writeValueAsString(orderItem1);
            String paymentJson = objectMapper.writeValueAsString(payment1);
            String discountJson = objectMapper.writeValueAsString(discount1);


            String customerFilePath = "/Users/j_mac/OnlineBookShop/OnlineBookShop/src/main/java/json/customers.json";
            String orderFilePath = "/Users/j_mac/OnlineBookShop/OnlineBookShop/src/main/java/json/orders.json";
            String orderItemFilePath = "/Users/j_mac/OnlineBookShop/OnlineBookShop/src/main/java/json/orderItems.json";
            String paymentFilePath = "/Users/j_mac/OnlineBookShop/OnlineBookShop/src/main/java/json/payments.json";
            String discountFilePath = "/Users/j_mac/OnlineBookShop/OnlineBookShop/src/main/java/json/discounts.json";


            File customerFile = new File(customerFilePath);
            File orderFile = new File(orderFilePath);
            File orderItemFile = new File(orderItemFilePath);
            File paymentFile = new File(paymentFilePath);
            File discountFile = new File(discountFilePath);


            objectMapper.writeValue(customerFile, customerJson);
            objectMapper.writeValue(orderFile, orderJson);
            objectMapper.writeValue(orderItemFile, orderItemJson);
            objectMapper.writeValue(paymentFile, paymentJson);
            objectMapper.writeValue(discountFile, discountJson);

            logger.info("JSON files created and saved successfully.");
        } catch (IOException e) {
            logger.error("Error occurred while creating or saving JSON files: " + e.getMessage());
        }
    }
}

