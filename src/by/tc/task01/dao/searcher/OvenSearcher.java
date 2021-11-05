package by.tc.task01.dao.searcher;

import by.tc.task01.dao.parser.ApplianceRepository;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OvenSearcher implements Searchable{
    private ApplianceRepository instance;
    private final List<Appliance> appliances;
    private List<Appliance> appliancesByCriteria;
    private Map<String, Object> parametersOfInstance;

    public OvenSearcher() {
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

        Oven oven = (Oven) appliance;

        parametersOfInstance.put(SearchCriteria.Oven.POWER_CONSUMPTION.toString(), oven.getPowerConsumption());
        parametersOfInstance.put(SearchCriteria.Oven.WEIGHT.toString(), oven.getWeight());
        parametersOfInstance.put(SearchCriteria.Oven.CAPACITY.toString(), oven.getCapacity());
        parametersOfInstance.put(SearchCriteria.Oven.DEPTH.toString(), oven.getDepth());
        parametersOfInstance.put(SearchCriteria.Oven.HEIGHT.toString(), oven.getHeight());
        parametersOfInstance.put(SearchCriteria.Oven.WIDTH.toString(), oven.getWidth());

        return parametersOfInstance;
    }

    private  boolean isValidInstance(Map<String, Object> putInside, Criteria criteria) {
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