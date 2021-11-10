package by.tc.task01.service.validation;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;

public abstract class Validator {

    /**
     * Check if chosen criteria are valid (bigger than 0)
     *
     * @param criteria
     * @return true if criteria are valid
     */
    public static boolean criteriaValidator(Criteria criteria) {

        for (Map.Entry<String, Object> parameter : criteria.getCriteria().entrySet()) {
            if(parameter.getKey().equals("POWER_CONSUMPTION") && Integer.parseInt(parameter.getValue().toString())  <= 0) {
                return false;
            }

            if(parameter.getKey().equals("WEIGHT") && Double.parseDouble(parameter.getValue().toString())  <= 0) {
                return false;
            }

            if(parameter.getKey().equals("CAPACITY") && Integer.parseInt(parameter.getValue().toString())  <= 0) {
                return false;
            }

            if(parameter.getKey().equals("DEPTH") && Double.parseDouble(parameter.getValue().toString())  <= 0) {
                return false;
            }

            if(parameter.getKey().equals("HEIGHT") && Double.parseDouble(parameter.getValue().toString())  <= 0) {
                return false;
            }

            if(parameter.getKey().equals("WIDTH") && Double.parseDouble(parameter.getValue().toString())  <= 0) {
                return false;
            }

            if(parameter.getKey().equals("FREEZER_CAPACITY") && Integer.parseInt(parameter.getValue().toString())  <= 0) {
                return false;
            }

            if(parameter.getKey().equals("OVERALL_CAPACITY") && Double.parseDouble(parameter.getValue().toString())  <= 0) {
                return false;
            }
        }
        return true;
    }

    /**
     *Check chosen criteria by type of appliance
     *
     * @param appliance
     * @return true if criteria are valid for chosen type of appliance
     */

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