package by.tc.task01.dao.parser;

import by.tc.task01.entity.Appliance;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface Parcelable {

    /**
     * Parse XML file to create List of Appliance instances
     * Every instance content properties parsed from XML file
     *
     * @return List of instances
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws SAXException
     */
    List<Appliance> parseApplianceXML() throws IOException, ParserConfigurationException, SAXException;
}
