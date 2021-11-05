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

public class RefrigeratorSearcher implements Searchable{
    private ApplianceRepository instance;
    private final List<Appliance> appliances;
    private List<Appliance> appliancesByCriteria;
    private Map<String, Object> parametersOfInstance;

    public RefrigeratorSearcher() {
        instance = ApplianceRepository.getInstance();
        appliances = instance.getData();
    }

    @Override
    public List<Appliance> search(Criteria criteria) {

        appliancesByCriteria = new ArrayList<>();

        for (Appliance appliance : appliances) {
            if (appliance.getClass().getSimpleName().equals(criteria.getGroupSearchName())) {

                parametersOfInstance = getParemetrsOfInstance(appliance);

                if (isValidInstance(parametersOfInstance, criteria)) {
                    appliancesByCriteria.add(appliance);
                }
            }
        }

        return appliancesByCriteria;
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

    private boolean isValidInstance(Map<String, Object> putInside, Criteria criteria) {
        int criteriaAmount = criteria.getCriteria().entrySet().size();

        for (Map.Entry<String, Object> instanceParameter : putInside.entrySet()) {
            for (Map.Entry<String, Object> criteriaParameter : criteria.getCriteria().entrySet()) {
                if (criteriaParameter.getKey().equals(instanceParameter.getKey()) && criteriaParameter.getValue().equals(instanceParameter.getValue())) {
                    criteriaAmount--;
                    if(criteriaAmount == 0) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

}
