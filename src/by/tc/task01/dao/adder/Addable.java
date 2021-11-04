package by.tc.task01.dao.adder;

import by.tc.task01.entity.Appliance;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

public interface Addable {

    boolean add(Appliance newAppliance) throws TransformerException;
}
