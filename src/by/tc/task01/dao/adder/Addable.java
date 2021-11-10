package by.tc.task01.dao.adder;

import by.tc.task01.entity.Appliance;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

public interface Addable {

    /**
     * Add properties of the instance of Appliance to XML file
     *
     * @param newAppliance
     * @return true if adding was successful
     * @throws TransformerException
     */

    boolean add(Appliance newAppliance);
}
