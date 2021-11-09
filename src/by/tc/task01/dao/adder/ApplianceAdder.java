package by.tc.task01.dao.adder;

import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.SearchCriteria;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public final class ApplianceAdder {

    private static ApplianceAdder instance;
    private final OvenAdder ovenAdder;
    private final RefrigeratorAdder refrigeratorAdder;

    public static ApplianceAdder getInstance() throws IOException, ParserConfigurationException, SAXException {
        instance = new ApplianceAdder();
        return instance;
    }

    private ApplianceAdder() throws IOException, ParserConfigurationException, SAXException {
       ovenAdder = new OvenAdder();
       refrigeratorAdder = new RefrigeratorAdder();
    }

    public boolean add(Appliance appliance) throws TransformerException {
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
