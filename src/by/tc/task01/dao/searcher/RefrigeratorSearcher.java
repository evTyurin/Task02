package by.tc.task01.dao.searcher;

import by.tc.task01.dao.parser.ApplianceRepository;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RefrigeratorSearcher implements Searchable {
    private ApplianceRepository instance;
    private final List<Appliance> appliances;
    private List<Appliance> appliancesSearchByCriteria;
    private Map<String, Object> parametersOfInstance;

    RefrigeratorSearcher() {
        instance = ApplianceRepository.getInstance();
        appliances = instance.getData();
    }

    @Override
    public List<Appliance> search(Criteria criteria) {

        appliancesSearchByCriteria = new ArrayList<>();

        for (Appliance appliance : appliances) {
            if(isEqualParameters(appliance, criteria)) {
                appliancesSearchByCriteria.add(appliance);
            }
        }
        return appliancesSearchByCriteria;
    }

    private boolean isEqualParameters(Appliance appliance, Criteria criteria) {
        if (isEqualApplianceType(appliance, criteria)) {
            parametersOfInstance = getParemetrsOfInstance(appliance);
            return isEqualCriteria(parametersOfInstance, criteria);
        }
        return false;
    }

    private Map<String, Object> getParemetrsOfInstance(Appliance appliance) {
        parametersOfInstance = new HashMap();

        Refrigerator refrigerator = (Refrigerator) appliance;

        parametersOfInstance.put(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString(), refrigerator.getOverallCapacity());
        parametersOfInstance.put(SearchCriteria.Refrigerator.WEIGHT.toString(), refrigerator.getWeight());
        parametersOfInstance.put(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString(), refrigerator.getFreezerCapacity());
        parametersOfInstance.put(SearchCriteria.Refrigerator.HEIGHT.toString(), refrigerator.getHeight());
        parametersOfInstance.put(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString(), refrigerator.getPowerConsumption());
        parametersOfInstance.put(SearchCriteria.Refrigerator.WIDTH.toString(), refrigerator.getWidth());

        return parametersOfInstance;
    }

    private boolean isEqualCriteria(Map<String, Object> putInside, Criteria criteria) {
        if (putInside.entrySet().retainAll(criteria.getCriteria().entrySet())) {
            return putInside.equals(criteria.getCriteria());
        }
        return false;
    }

    private boolean isEqualApplianceType (Appliance appliance, Criteria criteria) {
        return appliance.getClass().getSimpleName().equals(criteria.getGroupSearchName());
    }

}
