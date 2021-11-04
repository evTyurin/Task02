package by.tc.task01.dao.searcher;

import by.tc.task01.dao.adder.Addable;
import by.tc.task01.dao.adder.OvenAdder;
import by.tc.task01.dao.adder.RefrigeratorAdder;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

public class Invoker {
    private Searchable searchOven;
    private Searchable searchRefrigerator;

    public Invoker() throws IOException, ParserConfigurationException, SAXException {
//        searchOven = new OvenAdder();
        searchRefrigerator = new RefrigeratorSearcher();
    }

    public void setSearchOven(Searchable searchOven) {
        this.searchOven = searchOven;
    }

    public void setSearchRefrigerator(Searchable searchRefrigerator) {
        this.searchRefrigerator = searchRefrigerator;
    }

//    public List<Appliance> searchOven (List<Appliance> appliances) {
//
//        return searchOven.search(Criteria criteria);
//    }

//    public List<Appliance> searchRefrigerator (List<Appliance> appliances) {
//
//        return searchRefrigerator.search(Criteria criteria);
//    }


}
