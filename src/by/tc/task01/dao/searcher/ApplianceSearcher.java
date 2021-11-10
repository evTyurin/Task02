package by.tc.task01.dao.searcher;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import java.util.Collections;
import java.util.List;

public class ApplianceSearcher {

    private static ApplianceSearcher instance;
    private OvenSearcher ovenSearcher;
    private RefrigeratorSearcher refrigeratorSearcher;

    public static ApplianceSearcher getInstance() {
        if (instance == null) {
            instance = new ApplianceSearcher();
        }
        return instance;
    }

    public ApplianceSearcher() {
        ovenSearcher = new OvenSearcher();
        refrigeratorSearcher = new RefrigeratorSearcher();
    }

    public List<Appliance> search(Criteria criteria) {
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
