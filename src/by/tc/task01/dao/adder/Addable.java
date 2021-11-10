package by.tc.task01.dao.adder;

import by.tc.task01.entity.Appliance;

public interface Addable {

    /**
     * Add properties of the instance of Appliance to XML file
     *
     * @param newAppliance
     * @return true if adding was successful
     */

    boolean add(Appliance newAppliance);
}
