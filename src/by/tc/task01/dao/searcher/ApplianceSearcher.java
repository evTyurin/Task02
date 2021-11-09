package by.tc.task01.dao.searcher;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ApplianceSearcher {

    private static ApplianceSearcher instance;
    private OvenSearcher ovenSearcher;
    private RefrigeratorSearcher refrigeratorSearcher;

    public static ApplianceSearcher getApplianceSearcher() throws IOException, ParserConfigurationException, SAXException {
        instance = new ApplianceSearcher();
        return instance;
    }

    public ApplianceSearcher() throws IOException, ParserConfigurationException, SAXException {

        ovenSearcher = new OvenSearcher();
        refrigeratorSearcher = new RefrigeratorSearcher();
    }

    public List<Appliance> search(Criteria criteria) throws TransformerException {
        switch (criteria.getGroupSearchName()) {
            case SearchCriteria.OVEN: {
                return instance.ovenSearcher.search(criteria);
            }
            case SearchCriteria.REFRIGERATOR: {
                return instance.refrigeratorSearcher.search(criteria);
            }
        }
        return Collections.EMPTY_LIST;
    }
}
