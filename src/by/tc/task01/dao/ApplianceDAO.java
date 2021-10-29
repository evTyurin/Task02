package by.tc.task01.dao;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

public interface ApplianceDAO {

    List<Appliance> find(Criteria criteria) throws IOException, ParserConfigurationException, SAXException;

    void add(String applianceType, Appliance appliance) throws ParserConfigurationException, IOException, TransformerException, SAXException;

}
