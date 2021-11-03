package by.tc.task01.dao.Parser;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApplianceXMLParser {

    private List<Appliance> appliances;
    private OvenParser oven;
    private RefrigeratorParser refrigerator;

    public ApplianceXMLParser() {};

    public void setAppliances(List<Appliance> appliances) {
        this.appliances = appliances;
    }

    public List<Appliance> getAppliances() {
        return appliances;
    }

    public void setOven(OvenParser oven) {
        this.oven = oven;
    }

    public OvenParser getOven() {
        return oven;
    }

    public void setRefrigerator(RefrigeratorParser refrigerator) {
        this.refrigerator = refrigerator;
    }

    public RefrigeratorParser getRefrigerator() {
        return refrigerator;
    }

    public List<Appliance> executeParser() throws IOException, ParserConfigurationException, SAXException {
        Repository repository = Repository.getInstance();
        Document document = repository.parseXML();

        appliances = new ArrayList<>();
        oven = new OvenParser();
        refrigerator = new RefrigeratorParser();

        oven.parseApplianceXML(document, appliances);

        refrigerator.parseApplianceXML(document, appliances);

        return appliances;
    }

    public List<Appliance> findByCriteria(Criteria criteria) throws IOException, ParserConfigurationException, SAXException {

        List<Appliance> appliancesByCriteria = new ArrayList<>();

        appliancesByCriteria.addAll(oven.findByCriteria(appliances, criteria));

        appliancesByCriteria.addAll(refrigerator.findByCriteria(appliances, criteria));

        return appliances;
    }

}
