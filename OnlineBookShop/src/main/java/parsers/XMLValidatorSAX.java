package parsers;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

public class XMLValidatorSAX {
    public static void main(String[] args) {
        String xmlFilePath = "/Users/j_mac/OnlineBookShop/OnlineBookShop/src/main/resources/xml xsd/BookStock.xml";
        String xsdFilePath = "/Users/j_mac/OnlineBookShop/OnlineBookShop/src/main/resources/xml xsd/BookStocks.xsd";

        try {
            // Create a SAXParserFactory
            SAXParserFactory factory = SAXParserFactory.newInstance();

            // Enable validation against XSD
            factory.setValidating(true);
            factory.setNamespaceAware(true);

            // Create a SAXParser
            SAXParser parser = factory.newSAXParser();

            // Get the XMLReader from the SAXParser
            XMLReader xmlReader = parser.getXMLReader();

            // Set error handler to handle validation errors
            ErrorHandler errorHandler = new ErrorHandler() {
                @Override
                public void warning(SAXParseException exception) throws SAXException {
                    System.out.println("Warning: " + exception.getMessage());
                }

                @Override
                public void error(SAXParseException exception) throws SAXException {
                    System.out.println("Error: " + exception.getMessage());
                }

                @Override
                public void fatalError(SAXParseException exception) throws SAXException {
                    System.out.println("Fatal Error: " + exception.getMessage());
                }
            };
            xmlReader.setErrorHandler(errorHandler);

            // Parse the XML file
            xmlReader.parse(xmlFilePath);

            // If no exception is thrown during parsing, the XML is valid
            System.out.println("XML is valid.");
        } catch (SAXException e) {
            System.out.println("XML is not valid. Reason: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
