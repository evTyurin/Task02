package by.tc.task01.dao.exeption;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public abstract class DAOException {
    public static void throwException(IOException e) {
        throw new RuntimeException("Error. Problem with reading file", e);
    }

    public static void throwException(SAXException e) {
        throw new RuntimeException("Error with analyzing file", e);
    }

    public static void throwException(ParserConfigurationException e) {
        throw new RuntimeException("Parse error", e);
    }

    public static void throwException(TransformerException e) {
        throw new RuntimeException("Error. Can't be written into the file", e);
    }

}
