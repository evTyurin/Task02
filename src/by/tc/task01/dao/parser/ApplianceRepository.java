package by.tc.task01.dao.parser;

import by.tc.task01.entity.Appliance;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.util.List;

public class ApplianceRepository {
    private static ApplianceRepository instance;
    private List<Appliance> data;
    private final ApplianceXMLParser parser;

    private ApplianceRepository() {

        parser = new ApplianceXMLParser();
        try {
            data = parser.parse();
        } catch (ParserConfigurationException | IOException | SAXException ignored) {
            throw new RuntimeException() {};
        }

    }

    public void updateApplianceRepository() {
        try {
            data = parser.parse();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException() {};
        }

    }

    public List<Appliance> getData(){
        return data;
    }

    public static ApplianceRepository getInstance() {
        if (instance == null) {
            instance = new ApplianceRepository();
        }
        return instance;
    }
}