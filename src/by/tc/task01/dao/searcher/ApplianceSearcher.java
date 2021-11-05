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
    private final SearcherInvoker invoker;

    public ApplianceSearcher() throws IOException, ParserConfigurationException, SAXException {
        this.invoker = new SearcherInvoker();
    }

    public List<Appliance> search(Criteria criteria) throws TransformerException {
        switch (criteria.getGroupSearchName()) {
            case SearchCriteria.OVEN: {
                return invoker.searchOven(criteria);
            }
            case SearchCriteria.REFRIGERATOR: {
                return invoker.searchRefrigerator(criteria);
            }
        }
        return Collections.EMPTY_LIST;
    }
}
