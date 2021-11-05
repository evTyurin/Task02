package by.tc.task01.dao.util;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ApplianceHandlerUtil {
    private static ApplianceHandlerUtil instance;
    private static String pathToXML;
    private Document documentForParsing;

    public Document getDocument() {
        return documentForParsing;
    }

    public static void setInstance(ApplianceHandlerUtil instance) {
        ApplianceHandlerUtil.instance = instance;
    }

    public static String getPathToXML() {
        return pathToXML;
    }

    public static void setPathToXML(String pathToXML) {
        ApplianceHandlerUtil.pathToXML = pathToXML;
    }

    public void setDocumentForParsing(Document documentForParsing) {
        this.documentForParsing = documentForParsing;
    }

    private ApplianceHandlerUtil() throws ParserConfigurationException, IOException, SAXException {
        try {
            updateDocumentForParsing();
        } catch (ParserConfigurationException | IOException | SAXException ignore) {
            throw new RuntimeException(){};
        }
    }

    public static ApplianceHandlerUtil getInstance() {
        try {
            if (instance == null) {
                instance = new ApplianceHandlerUtil();
            }
        } catch (ParserConfigurationException | IOException | SAXException ignore) {

        }
        return instance;
    }

    public File getApplianceXMLPath() {
        ClassLoader classLoader = ApplianceHandlerUtil.class.getClassLoader();
        return new File(Objects.requireNonNull(classLoader.getResource(pathToXML)).getFile());
    }

    public void updateDocumentForParsing() throws ParserConfigurationException, IOException, SAXException {
        documentForParsing = getDocumentForParsing();
    }

    public Document getDocumentForParsing() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        documentForParsing = builder.parse(getApplianceXMLPath());

        return documentForParsing;
    }
}
