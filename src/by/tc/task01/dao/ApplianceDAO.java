package by.tc.task01.dao;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import java.util.List;


public interface ApplianceDAO {

    /**
     * Find Appliance instances among all Appliance instances that kept in List of appliances
     *
     * @param criteria
     * @return List of Appliance instances chosen by criteria
     */
    List<Appliance> find(Criteria criteria);

    /**
     * Add properties of the instance of Appliance to XML file
     *
     * @param appliance
     * @return true if adding was successful
     */
    boolean add(Appliance appliance);
}
