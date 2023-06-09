package jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import jaxb.DataWrapper;
import models.Customers;
import models.Orders;
import models.Payments;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class JAXBMain {
    public static void main(String[] args) {

        Logger logger = LogManager.getLogger(JAXBMain.class);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DataWrapper.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            File xmlFile = new File("/Users/j_mac/OnlineBookShop/OnlineBookShop/src/main/resources/xmlJAXB/PaymentsJAXB.xml");
            DataWrapper data = (DataWrapper) unmarshaller.unmarshal(xmlFile);

            Payments payment = data.getPayment();
            Customers customer = data.getCustomer();
            Orders order = data.getOrder();

            logger.info(payment);
            logger.info(customer);
            logger.info(order);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
