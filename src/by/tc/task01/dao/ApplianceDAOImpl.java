package by.tc.task01.dao;

import by.tc.task01.dao.adder.ApplianceAdder;
import by.tc.task01.dao.searcher.ApplianceSearcher;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

public final class ApplianceDAOImpl implements ApplianceDAO {

    ApplianceDAOImpl() {}

    @Override
    public List<Appliance> find(Criteria criteria) {
        ApplianceSearcher applianceSearcher = ApplianceSearcher.getInstance();
        return applianceSearcher.search(criteria);
    }

    @Override
    public boolean add(Appliance appliance) {
        ApplianceAdder applianceAdder = ApplianceAdder.getInstance();
        return applianceAdder.add(appliance);
    }
}