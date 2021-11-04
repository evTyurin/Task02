package by.tc.task01.dao.parser;

import by.tc.task01.entity.Appliance;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface Parseble {
    List<Appliance> parseApplianceXML () throws IOException, ParserConfigurationException, SAXException;
}
