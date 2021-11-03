package by.tc.task01.dao.Parser;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;
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

public class RefrigeratorParser implements ParseXML{

    public RefrigeratorParser() throws IOException, SAXException, ParserConfigurationException {}

    @Override
    public List<Appliance> parseApplianceXML (Document document, List<Appliance> appliances)  throws IOException, ParserConfigurationException, SAXException {

        NodeList elements = document.getElementsByTagName(Refrigerator.class.getName());

        for (int i = 0; i < elements.getLength(); i++) {
            NamedNodeMap attributes = elements.item(i).getAttributes();

            String model = attributes.getNamedItem("MODEL").getNodeValue();
            double price = Double.parseDouble(attributes.getNamedItem("PRICE").getNodeValue());
            int powerConsumption = Integer.parseInt(attributes.getNamedItem(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString()).getNodeValue());
            double weight = Double.parseDouble(attributes.getNamedItem(SearchCriteria.Refrigerator.WEIGHT.toString()).getNodeValue());
            double freezerCapacity = Double.parseDouble(attributes.getNamedItem(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString()).getNodeValue());
            double overallCapacity = Double.parseDouble(attributes.getNamedItem(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString()).getNodeValue());
            double height = Double.parseDouble(attributes.getNamedItem(SearchCriteria.Refrigerator.HEIGHT.toString()).getNodeValue());
            double width = Double.parseDouble(attributes.getNamedItem(SearchCriteria.Refrigerator.WIDTH.toString()).getNodeValue());

            appliances.add(new Refrigerator(model, SearchCriteria.REFRIGERATOR, price, powerConsumption, weight, freezerCapacity, overallCapacity, height, width));

        }
        return appliances;
    }

    public boolean checkByCriteria (Criteria criteria) {

        int criterionCounter = 0;
        int amountOfCriteria = criteria.getCriteria().entrySet().size();
        for (Map.Entry<String, Object> criterion : criteria.getCriteria().entrySet()) {

            for (SearchCriteria.Refrigerator refrigeratorCriterion: SearchCriteria.Refrigerator.values()) {

                if (refrigeratorCriterion.toString().equals(criterion.getKey())) {
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

        for (Appliance refrigerator: appliances) {

            if (refrigerator.getType().equals(Refrigerator.class.getName())){
                //check and add to list
            }

        }

        return null;
    }


}