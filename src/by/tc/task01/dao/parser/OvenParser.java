package by.tc.task01.dao.parser;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.SearchCriteria;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OvenParser implements Parcelable {
    private final List<Appliance> appliances;
    private final NodeList elements;
    private Oven oven;

    OvenParser(Document document) {
        appliances = new ArrayList<>();
        elements = document.getElementsByTagName(Oven.class.getSimpleName());
    }

    @Override
    public List<Appliance> parseApplianceXML() throws IOException, ParserConfigurationException, SAXException {

        for (int i = 0; i < elements.getLength(); i++) {

            oven = createAppliance(elements, i);
            appliances.add(oven);
            oven = null;
        }
        return appliances;
    }

    private Oven createAppliance(NodeList elements, int numberOfElement) {
        NamedNodeMap attributes = elements.item(numberOfElement).getAttributes();

        String model = attributes.getNamedItem(SearchCriteria.Appliance.MODEL.toString()).getNodeValue();
        double price = Double.parseDouble(attributes.getNamedItem(SearchCriteria.Appliance.PRICE.toString()).getNodeValue());
        int powerConsumption = Integer.parseInt(attributes.getNamedItem(SearchCriteria.Oven.POWER_CONSUMPTION.toString()).getNodeValue());
        double weight = Double.parseDouble(attributes.getNamedItem(SearchCriteria.Oven.WEIGHT.toString()).getNodeValue());
        int capacity = Integer.parseInt(attributes.getNamedItem(SearchCriteria.Oven.CAPACITY.toString()).getNodeValue());
        double depth = Double.parseDouble(attributes.getNamedItem(SearchCriteria.Oven.DEPTH.toString()).getNodeValue());
        double height = Double.parseDouble(attributes.getNamedItem(SearchCriteria.Oven.HEIGHT.toString()).getNodeValue());
        double width = Double.parseDouble(attributes.getNamedItem(SearchCriteria.Oven.WIDTH.toString()).getNodeValue());

        return new Oven(model, price, powerConsumption, weight, capacity, depth, height, width);
    }

}
