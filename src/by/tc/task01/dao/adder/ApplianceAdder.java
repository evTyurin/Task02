package by.tc.task01.dao.adder;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.SearchCriteria;

public class ApplianceAdder {

    private static ApplianceAdder instance;
    private final OvenAdder ovenAdder;
    private final RefrigeratorAdder refrigeratorAdder;

    public static ApplianceAdder getInstance()  {
        if (instance == null) {
            instance = new ApplianceAdder();
        }
        return instance;
    }

    private ApplianceAdder() {
       ovenAdder = new OvenAdder();
       refrigeratorAdder = new RefrigeratorAdder();
    }

    public boolean add(Appliance appliance) {
        switch (appliance.getClass().getSimpleName()) {
            case SearchCriteria.OVEN: {
                return instance.ovenAdder.add(appliance);
            }
            case SearchCriteria.REFRIGERATOR: {
                return instance.refrigeratorAdder.add(appliance);
            }
        }
        return false;
    }

}
