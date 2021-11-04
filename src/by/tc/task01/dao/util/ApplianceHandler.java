package by.tc.task01.dao.util;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ApplianceHandler {
    private static ApplianceHandler instance;

    private Document documentForParsing;

    public Document getDocument () {
        return documentForParsing;
    }

    private ApplianceHandler() throws ParserConfigurationException, IOException, SAXException {
        try {
            updateDocumentForParsing();
        } catch (ParserConfigurationException | IOException | SAXException ignore) {
            System.out.println("someText");
        }
    }

    public File getApplianceXMLPath() {
        ClassLoader classLoader = DOMParser_Deprecated.class.getClassLoader();
        return new File(Objects.requireNonNull(classLoader.getResource("resources/appliances.xml")).getFile());
    }

    public static ApplianceHandler getInstance()  {
        try {
        if (instance == null) {
            instance = new ApplianceHandler();
        }
        } catch (ParserConfigurationException | IOException | SAXException ignore) {

        }
        return instance;
    }

    public void updateDocumentForParsing () throws ParserConfigurationException, IOException, SAXException {
        documentForParsing = getDocumentForParsing();
    }

    public Document getDocumentForParsing () throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        documentForParsing = builder.parse(getApplianceXMLPath());

        return documentForParsing;
    }
}
