package by.tc.task01.dao.adder;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.SearchCriteria;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class ApplianceAdder {
    private final ApplianceInvoker invoker;

    public ApplianceAdder() throws IOException, ParserConfigurationException, SAXException {
       invoker = new ApplianceInvoker();
    }

    public boolean add(Appliance appliance) throws TransformerException {
        switch (appliance.getClass().getSimpleName()) {
            case SearchCriteria.OVEN: {
                invoker.addOven(appliance);
                return true;
            }
            case SearchCriteria.REFRIGERATOR: {
                invoker.addRefrigerator(appliance);
                return true;
            }
        }
        return false;
    }

}
