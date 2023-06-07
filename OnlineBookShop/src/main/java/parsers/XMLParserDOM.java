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

public class XMLParserDOM {
    public static void main(String[] args) {
        String xmlFilePath = "/Users/j_mac/OnlineBookShop/OnlineBookShop/src/main/resources/xml xsd/BookStock.xml";

        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file and create a Document object
            File xmlFile = new File(xmlFilePath);
            Document document = builder.parse(xmlFile);

            // Get the root element of the XML
            Element root = document.getDocumentElement();

            // Process the XML data
            NodeList bookStockNodes = root.getElementsByTagName("bookStock");
            for (int i = 0; i < bookStockNodes.getLength(); i++) {
                Element bookStockElement = (Element) bookStockNodes.item(i);

                // Extract data from the bookStock element
                int bookStockId = Integer.parseInt(getElementText(bookStockElement, "book_stock_id"));
                String address = getElementText(bookStockElement, "address");
                String phoneNumber = getElementText(bookStockElement, "phone_number");
                int departmentId = Integer.parseInt(getElementText(bookStockElement, "department_id"));

                // Create a BookStock object or perform any other processing
                BookStock bookStock = new BookStock(bookStockId, address, phoneNumber, departmentId);

                // Do something with the BookStock object
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

