package by.tc.task01.dao.Parser;

import by.tc.task01.dao.DOMParser_Deprecated;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Repository {
    private static final Repository instance = new Repository();

    private static final String pathToXMLDatabase = "resources/db.xml";

    private Repository() {}

    public static Repository getInstance() {
        return instance;
    }

    public static String getPathToXMLDatabase() {
        return pathToXMLDatabase;
    }

    public Document parseXML () throws ParserConfigurationException, IOException, SAXException {
        ClassLoader classLoader = DOMParser_Deprecated.class.getClassLoader();
        final File DB_PATH = new File(classLoader.getResource(pathToXMLDatabase).getFile());
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(DB_PATH);
    }
}
