package by.tc.task01.main;

import by.tc.task01.entity.Appliance;

import java.util.List;

public class PrintApplianceInfo {

    /**
     * Print on console information about Appliance instance
     *
     * @param appliance
     */
    public static void print(Appliance appliance) {
        System.out.println(appliance);
    }

    /**
     * Print on console information about Appliance instances
     *
     * @param applianceList
     */

    public static void print(List<Appliance> applianceList) {
        for (Appliance appliance : applianceList) {
            System.out.println(appliance);
        }

    }
}
