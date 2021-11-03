package by.tc.task01.service.validation;

import by.tc.task01.dao.DOMParser_Deprecated;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;

public class Validator {
    public static boolean criteriaValidator(Criteria criteria) {

        for (Map.Entry<String, Object> parameter : criteria.getCriteria().entrySet()) {
            if(parameter.getKey().equals(DOMParser_Deprecated.POWER_CONSUMPTION) && Integer.parseInt(parameter.getValue().toString())  <= 0) {
                return false;
            }

            if(parameter.getKey().equals(DOMParser_Deprecated.WEIGHT) && Double.parseDouble(parameter.getValue().toString())  <= 0) {
                return false;
            }

            if(parameter.getKey().equals(DOMParser_Deprecated.CAPACITY) && Integer.parseInt(parameter.getValue().toString())  <= 0) {
                return false;
            }

            if(parameter.getKey().equals(DOMParser_Deprecated.DEPTH) && Double.parseDouble(parameter.getValue().toString())  <= 0) {
                return false;
            }

            if(parameter.getKey().equals(DOMParser_Deprecated.HEIGHT) && Double.parseDouble(parameter.getValue().toString())  <= 0) {
                return false;
            }

            if(parameter.getKey().equals(DOMParser_Deprecated.WIDTH) && Double.parseDouble(parameter.getValue().toString())  <= 0) {
                return false;
            }

            if(parameter.getKey().equals(DOMParser_Deprecated.FREEZER_CAPACITY) && Integer.parseInt(parameter.getValue().toString())  <= 0) {
                return false;
            }

            if(parameter.getKey().equals(DOMParser_Deprecated.OVERALL_CAPACITY) && Integer.parseInt(parameter.getValue().toString())  <= 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean applianceValidator(Appliance appliance) {

        String applianceClass = appliance.getClass().getSimpleName();

        switch (applianceClass) {
            case SearchCriteria.REFRIGERATOR: {
                Refrigerator refrigerator = (Refrigerator) appliance;
                if (appliance.getPrice() <= 0 ||
                        refrigerator.getHeight() <= 0 ||
                        refrigerator.getWidth() <= 0 ||
                        refrigerator.getOverallCapacity() < 0 ||
                        refrigerator.getFreezerCapacity() < 0 ||
                        refrigerator.getPowerConsumption() < 0) {
                    return false;
                }

            } break;

            case SearchCriteria.OVEN: {
                Oven oven = (Oven) appliance;
                if (appliance.getPrice() <= 0 ||
                        oven.getDepth() <= 0 ||
                        oven.getWidth() <= 0 ||
                        oven.getHeight() <= 0 ||
                        oven.getCapacity() < 0 ||
                        oven.getPowerConsumption() < 0) {
                    return false;
                }
            } break;
        }
        return true;
    }
}