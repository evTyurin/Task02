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
    private List<Appliance> appliancesSearchByCriteria;
    private Map<String, Object> parametersOfInstance;

    OvenSearcher() {
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

        Oven oven = (Oven) appliance;

        parametersOfInstance.put(SearchCriteria.Oven.POWER_CONSUMPTION.toString(), oven.getPowerConsumption());
        parametersOfInstance.put(SearchCriteria.Oven.WEIGHT.toString(), oven.getWeight());
        parametersOfInstance.put(SearchCriteria.Oven.CAPACITY.toString(), oven.getCapacity());
        parametersOfInstance.put(SearchCriteria.Oven.DEPTH.toString(), oven.getDepth());
        parametersOfInstance.put(SearchCriteria.Oven.HEIGHT.toString(), oven.getHeight());
        parametersOfInstance.put(SearchCriteria.Oven.WIDTH.toString(), oven.getWidth());

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