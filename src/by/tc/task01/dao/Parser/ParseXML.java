package by.tc.task01.dao.Parser;

import by.tc.task01.entity.Appliance;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface ParseXML {
    List<Appliance> parseApplianceXML (Document document, List<Appliance> list) throws IOException, ParserConfigurationException, SAXException;

}
