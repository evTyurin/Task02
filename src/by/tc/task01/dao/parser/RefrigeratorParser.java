package by.tc.task01.dao.parser;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.criteria.SearchCriteria;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RefrigeratorParser implements Parseble{

    private List<Appliance> appliances;
    private NodeList elements;
    private Refrigerator refrigerator;

    public RefrigeratorParser(Document document) {
        appliances = new ArrayList<>();
        elements = document.getElementsByTagName(Refrigerator.class.getSimpleName());
    }

    public List<Appliance> parseApplianceXML () throws IOException, ParserConfigurationException, SAXException {

        for (int i = 0; i < elements.getLength(); i++) {

            refrigerator = createAppliance(elements, i);
            appliances.add(refrigerator);
            refrigerator = null;
        }

        return appliances;
    }

    public void add (Appliance appliance) {
        appliances.add(appliance);
    }

    public Refrigerator createAppliance (NodeList elements, int numberOfElement) {
        NamedNodeMap attributes = elements.item(numberOfElement).getAttributes();

        String model = attributes.getNamedItem("MODEL").getNodeValue();
        double price = Double.parseDouble(attributes.getNamedItem("PRICE").getNodeValue());
        int powerConsumption = Integer.parseInt(attributes.getNamedItem(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString()).getNodeValue());
        double weight = Double.parseDouble(attributes.getNamedItem(SearchCriteria.Refrigerator.WEIGHT.toString()).getNodeValue());
        double freezerCapacity = Double.parseDouble(attributes.getNamedItem(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString()).getNodeValue());
        double overallCapacity = Double.parseDouble(attributes.getNamedItem(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString()).getNodeValue());
        double height = Double.parseDouble(attributes.getNamedItem(SearchCriteria.Refrigerator.HEIGHT.toString()).getNodeValue());
        double width = Double.parseDouble(attributes.getNamedItem(SearchCriteria.Refrigerator.WIDTH.toString()).getNodeValue());

        return new Refrigerator(model, price, powerConsumption, weight, freezerCapacity, overallCapacity, height, width);
    }
}
