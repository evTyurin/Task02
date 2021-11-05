package by.tc.task01.dao.searcher;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.util.List;

public interface Searchable {

    /**
     * Search instances of Appliance by criteria
     *
     * @param criteria
     * @return List of instances
     */

    List<Appliance> search (Criteria criteria);

}
