package by.tc.task01.dao.parser;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.criteria.SearchCriteria;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import java.util.ArrayList;
import java.util.List;

public class RefrigeratorParser implements Parsable {

    private final List<Appliance> appliances;
    private final NodeList elements;
    private Refrigerator refrigerator;

    RefrigeratorParser(Document document) {
        appliances = new ArrayList<>();
        elements = document.getElementsByTagName(Refrigerator.class.getSimpleName());
    }

    public List<Appliance> parseApplianceXML(){

        for (int numberOfAppliance = 0; numberOfAppliance < elements.getLength(); numberOfAppliance++) {

            refrigerator = createAppliance(elements, numberOfAppliance);
            appliances.add(refrigerator);
            refrigerator = null;
        }

        return appliances;
    }

    private Refrigerator createAppliance(NodeList elements, int numberOfElement) {
        NamedNodeMap attributes = elements.item(numberOfElement).getAttributes();

        String model = attributes.getNamedItem(SearchCriteria.Appliance.MODEL.toString()).getNodeValue();
        double price = Double.parseDouble(attributes.getNamedItem(SearchCriteria.Appliance.PRICE.toString()).getNodeValue());
        int powerConsumption = Integer.parseInt(attributes.getNamedItem(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString()).getNodeValue());
        double weight = Double.parseDouble(attributes.getNamedItem(SearchCriteria.Refrigerator.WEIGHT.toString()).getNodeValue());
        double freezerCapacity = Double.parseDouble(attributes.getNamedItem(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString()).getNodeValue());
        double overallCapacity = Double.parseDouble(attributes.getNamedItem(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString()).getNodeValue());
        double height = Double.parseDouble(attributes.getNamedItem(SearchCriteria.Refrigerator.HEIGHT.toString()).getNodeValue());
        double width = Double.parseDouble(attributes.getNamedItem(SearchCriteria.Refrigerator.WIDTH.toString()).getNodeValue());

        return new Refrigerator(model, price, powerConsumption, weight, freezerCapacity, overallCapacity, height, width);
    }
}
