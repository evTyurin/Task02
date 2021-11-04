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

public class Searcher {
    ApplianceRepository instance;
    List<Appliance> appliances;
    List<Appliance> appliancesByCriteria;
    Map<String, Object> parametersOfInstance;


    public Searcher() {
        instance = ApplianceRepository.getInstance();
        appliances = instance.getData();
    }


    public List<Appliance> search(Criteria criteria) {

        appliancesByCriteria = new ArrayList<>();
        parametersOfInstance = new HashMap();

        for (Appliance appliance : appliances) {
            if (appliance.getClass().getSimpleName().equals(criteria.getGroupSearchName())) {

                Refrigerator refrigerator = (Refrigerator) appliance;

                parametersOfInstance.put(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString(), refrigerator.getOverallCapacity());
                parametersOfInstance.put(SearchCriteria.Refrigerator.WEIGHT.toString(), refrigerator.getWeight());
                parametersOfInstance.put(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString(), refrigerator.getFreezerCapacity());
                parametersOfInstance.put(SearchCriteria.Refrigerator.HEIGHT.toString(), refrigerator.getHeight());
                parametersOfInstance.put(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString(), refrigerator.getPowerConsumption());
                parametersOfInstance.put(SearchCriteria.Refrigerator.WIDTH.toString(), refrigerator.getWidth());

                int criteriaAmount = criteria.getCriteria().entrySet().size();
                for (Map.Entry<String, Object> instanceParameter : parametersOfInstance.entrySet()) {

                    for (Map.Entry<String, Object> criteriaParameter : criteria.getCriteria().entrySet()) {

                        if (criteriaParameter.getKey().equals(instanceParameter.getKey()) && criteriaParameter.getValue().equals(instanceParameter.getValue())) {
                            criteriaAmount--;
                            if(criteriaAmount == 0) {
                                appliancesByCriteria.add(appliance);
                            }
                        }
                    }
                }
            }
        }
        return appliancesByCriteria;
    }
}