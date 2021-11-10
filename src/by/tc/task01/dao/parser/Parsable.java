package by.tc.task01.dao.parser;

import by.tc.task01.entity.Appliance;
import java.util.List;

public interface Parsable {

    /**
     * Parse XML file to create List of Appliance instances
     * Every instance content properties parsed from XML file
     *
     * @return List of instances
     */
    List<Appliance> parseApplianceXML();
}
