package by.tc.task01.service;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

public interface ApplianceService {

    /**
     * Send command to DAO to find Appliance instances among all Appliance instances that kept in List of appliances
     *
     * @param criteria
     * @return List of Appliance instances chosen by criteria
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws TransformerException
     */

    List<Appliance> find(Criteria criteria);

    /**
     * Send command to DAO to add properties of the instance of Appliance to XML file
     *
     * @param appliance
     * @return true if adding was successful
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws TransformerException
     * @throws SAXException
     */
    boolean add(Appliance appliance);

}