package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DOMParser;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

public class ApplianceDAOImpl implements ApplianceDAO {

    @Override
    public List<Appliance> find (Criteria criteria) throws IOException, ParserConfigurationException, SAXException {

        DOMParser parser = new DOMParser();

        List <Appliance> appliancesWithParameters = parser.findAppliance(criteria);

        return appliancesWithParameters;
    }

    @Override
    public void add(String applianceType, Appliance appliance) throws ParserConfigurationException, IOException, TransformerException, SAXException {

        DOMParser.addAppliance(applianceType, appliance);
    }
}