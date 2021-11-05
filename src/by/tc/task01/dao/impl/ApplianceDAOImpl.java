package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.adder.ApplianceAdder;
import by.tc.task01.dao.searcher.ApplianceSearcher;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

public class ApplianceDAOImpl implements ApplianceDAO {

    @Override
    public List<Appliance> find(Criteria criteria) throws IOException, ParserConfigurationException, SAXException, TransformerException {

        ApplianceSearcher applianceSearcher = new ApplianceSearcher();

        return applianceSearcher.search(criteria);
    }

    @Override
    public boolean add(Appliance appliance) throws ParserConfigurationException, IOException, TransformerException, SAXException {

        ApplianceAdder applianceAdder = new ApplianceAdder();
        applianceAdder.add(appliance);

        return true;
    }

}