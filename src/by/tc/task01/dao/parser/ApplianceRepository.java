package by.tc.task01.dao.parser;

import by.tc.task01.entity.Appliance;
import java.util.List;

public class ApplianceRepository {
    private static ApplianceRepository instance;
    private List<Appliance> data;
    private final ApplianceXMLParser parser;

    private ApplianceRepository() {
        parser = new ApplianceXMLParser();
        data = parser.parse();
    }

    public void updateApplianceRepository() {
        data = parser.parse();
    }

    public List<Appliance> getData(){
        return data;
    }

    public ApplianceXMLParser getParser() {
        return parser;
    }

    public static ApplianceRepository getInstance() {
        if (instance == null) {
            instance = new ApplianceRepository();
        }
        return instance;
    }
}