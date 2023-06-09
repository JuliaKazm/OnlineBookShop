package parsers;

import models.BookStock;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class XMLParserDOM {
    private static final Logger logger = LogManager.getLogger(XMLParserDOM.class);

    public static void main(String[] args) {
        String xmlFilePath = "/Users/j_mac/OnlineBookShop/OnlineBookShop/src/main/resources/xml xsd/BookStock.xml";

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parsing the XML file and create a Document object
            File xmlFile = new File(xmlFilePath);
            Document document = builder.parse(xmlFile);

            // Getting the root element of the XML
            Element root = document.getDocumentElement();

            // Processing the XML data
            NodeList bookStockNodes = root.getElementsByTagName("bookStock");
            for (int i = 0; i < bookStockNodes.getLength(); i++) {
                Element bookStockElement = (Element) bookStockNodes.item(i);

                // Extracting data from the bookStock element
                int bookStockId = Integer.parseInt(getElementText(bookStockElement, "book_stock_id"));
                String address = getElementText(bookStockElement, "address");
                String phoneNumber = getElementText(bookStockElement, "phone_number");
                int departmentId = Integer.parseInt(getElementText(bookStockElement, "department_id"));

                // Creating a BookStock object or perform any other processing
                BookStock bookStock = new BookStock(bookStockId, address, phoneNumber, departmentId);
                logger.debug(bookStock.toString());
            }
        } catch (IOException | SAXException e) {
            logger.error("An error occurred during XML parsing: " + e.getMessage());
        } catch (Exception e) {
            logger.error("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static String getElementText(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        Element tagElement = (Element) nodeList.item(0);
        return tagElement.getTextContent();
    }
}



/*package parsers;
import models.BookStock;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class XMLParserDOM {
    public static void main(String[] args) {
        String xmlFilePath = "/Users/j_mac/OnlineBookShop/OnlineBookShop/src/main/resources/xml xsd/BookStock.xml";

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file and create a Document object
            File xmlFile = new File(xmlFilePath);
            Document document = builder.parse(xmlFile);

            Element root = document.getDocumentElement();
            NodeList bookStockNodes = root.getElementsByTagName("bookStock");
            for (int i = 0; i < bookStockNodes.getLength(); i++) {
                Element bookStockElement = (Element) bookStockNodes.item(i);

                int bookStockId = Integer.parseInt(getElementText(bookStockElement, "book_stock_id"));
                String address = getElementText(bookStockElement, "address");
                String phoneNumber = getElementText(bookStockElement, "phone_number");
                int departmentId = Integer.parseInt(getElementText(bookStockElement, "department_id"));

                BookStock bookStock = new BookStock(bookStockId, address, phoneNumber, departmentId);

                System.out.println(bookStock.toString());
            }
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getElementText(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        Element tagElement = (Element) nodeList.item(0);
        return tagElement.getTextContent();
    }
}
*/
