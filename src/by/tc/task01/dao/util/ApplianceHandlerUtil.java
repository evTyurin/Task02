package by.tc.task01.dao.util;

import by.tc.task01.dao.exeption.DAOException;
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

    private ApplianceHandlerUtil() {
            updateDocumentForParsing();
    }

    public static ApplianceHandlerUtil getInstance() {
        if (instance == null) {
            instance = new ApplianceHandlerUtil();
        }
        return instance;
    }

    public File getApplianceXMLPath() {
        ClassLoader classLoader = ApplianceHandlerUtil.class.getClassLoader();
        return new File(Objects.requireNonNull(classLoader.getResource(pathToXML)).getFile());
    }

    public void updateDocumentForParsing()  {
        documentForParsing = getDocumentForParsing();
    }

    public Document getDocumentForParsing()  {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            documentForParsing = builder.parse(getApplianceXMLPath());
        }
        catch (ParserConfigurationException e) {
            DAOException.throwException(e);
        } catch (SAXException e) {
            DAOException.throwException(e);
        } catch (IOException e) {
            DAOException.throwException(e);
        }
        return documentForParsing;
    }
}
