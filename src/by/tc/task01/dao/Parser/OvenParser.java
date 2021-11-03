package by.tc.task01.dao.Parser;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class OvenParser implements ParseXML {

    public OvenParser() throws IOException, SAXException, ParserConfigurationException {}

    @Override
    public List<Appliance> parseApplianceXML (Document document, List<Appliance> appliances)  throws IOException, ParserConfigurationException, SAXException {

        NodeList elements = document.getElementsByTagName(Oven.class.getName());

        for (int i = 0; i < elements.getLength(); i++) {
            NamedNodeMap attributes = elements.item(i).getAttributes();

            String model = attributes.getNamedItem("MODEL").getNodeValue();
            double price = Double.parseDouble(attributes.getNamedItem("PRICE").getNodeValue());
            int powerConsumption = Integer.parseInt(attributes.getNamedItem(SearchCriteria.Oven.POWER_CONSUMPTION.toString()).getNodeValue());
            double weight = Double.parseDouble(attributes.getNamedItem(SearchCriteria.Oven.WEIGHT.toString()).getNodeValue());
            int capacity = Integer.parseInt(attributes.getNamedItem(SearchCriteria.Oven.CAPACITY.toString()).getNodeValue());
            double depth = Double.parseDouble(attributes.getNamedItem(SearchCriteria.Oven.DEPTH.toString()).getNodeValue());
            double height = Double.parseDouble(attributes.getNamedItem(SearchCriteria.Oven.HEIGHT.toString()).getNodeValue());
            double width = Double.parseDouble(attributes.getNamedItem(SearchCriteria.Oven.WIDTH.toString()).getNodeValue());

            appliances.add(new Oven(model, SearchCriteria.OVEN, price, powerConsumption, weight, capacity, depth, height, width));
        }
        return appliances;
    }

    private boolean checkByCriteria (Criteria criteria) {

        int criterionCounter = 0;
        int amountOfCriteria = criteria.getCriteria().entrySet().size();
        for (Map.Entry<String, Object> criterion : criteria.getCriteria().entrySet()) {

            for (SearchCriteria.Oven ovenCriterion: SearchCriteria.Oven.values()) {

                if (ovenCriterion.toString().equals(criterion.getKey())) {
                    criterionCounter++;
                }
            }
        }
        return criterionCounter == amountOfCriteria;
    }

    public List<Appliance> findByCriteria (List<Appliance> appliances, Criteria criteria) {
        if (!checkByCriteria(criteria)) {
            return null;
        }

        for (Appliance oven: appliances) {

            if (oven.getType().equals(Oven.class.getName())){
                //check and add to list
            }
        }

        return null;
    }


}
