package by.tc.task01.dao;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;


import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class DOMParser {

    public DOMParser() {};

    public static final File DB_PATH = new File("src\\resources\\db.xml");

    public final static String MODEL = "MODEL";
    public final static String PRICE = "PRICE";
    public final static String POWER_CONSUMPTION = "POWER_CONSUMPTION";
    public final static String WEIGHT = "WEIGHT";
    public final static String FREEZER_CAPACITY = "FREEZER_CAPACITY";
    public final static String OVERALL_CAPACITY = "OVERALL_CAPACITY";
    public final static String HEIGHT = "HEIGHT";
    public final static String WIDTH = "WIDTH";
    public final static String CAPACITY = "CAPACITY";
    public final static String DEPTH = "DEPTH";

    private static List<Appliance> appliances = new ArrayList<>();

    private static Document parseDB() throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(DB_PATH);
    }

    public List findAppliance(Criteria criteria) throws IOException, ParserConfigurationException, SAXException {
        Document document = parseDB();
        NodeList elements = document.getElementsByTagName(criteria.getGroupSearchName());

        Map<String, Object> parametersOfInstance;
        Map<Appliance, Map<String,Object> > applianceInstances = new HashMap<>();;

        for (int i = 0; i < elements.getLength(); i++) {
            NamedNodeMap attributes = elements.item(i).getAttributes();

            switch (criteria.getGroupSearchName()) {
                case SearchCriteria.REFRIGERATOR: {

                    parametersOfInstance = new HashMap<>();
                    applianceInstances = new HashMap<>();

                    String model = attributes.getNamedItem(MODEL).getNodeValue();
                    double price = Double.parseDouble(attributes.getNamedItem(PRICE).getNodeValue());
                    int powerConsumption = Integer.parseInt(attributes.getNamedItem(POWER_CONSUMPTION).getNodeValue());
                    double weight = Double.parseDouble(attributes.getNamedItem(WEIGHT).getNodeValue());
                    double freezerCapacity = Double.parseDouble(attributes.getNamedItem(FREEZER_CAPACITY).getNodeValue());
                    double overallCapacity = Double.parseDouble(attributes.getNamedItem(OVERALL_CAPACITY).getNodeValue());
                    double height = Double.parseDouble(attributes.getNamedItem(HEIGHT).getNodeValue());
                    double width = Double.parseDouble(attributes.getNamedItem(WIDTH).getNodeValue());

                    parametersOfInstance.put(MODEL, model);
                    parametersOfInstance.put(PRICE, price);
                    parametersOfInstance.put(POWER_CONSUMPTION, powerConsumption);
                    parametersOfInstance.put(WEIGHT, weight);
                    parametersOfInstance.put(FREEZER_CAPACITY,freezerCapacity);
                    parametersOfInstance.put(OVERALL_CAPACITY, overallCapacity);
                    parametersOfInstance.put(HEIGHT, height);
                    parametersOfInstance.put(WIDTH, width);

                    applianceInstances.put(new Refrigerator(model, price, powerConsumption, weight, freezerCapacity, overallCapacity, height, width), parametersOfInstance);

                } break;

                case SearchCriteria.OVEN: {

                    parametersOfInstance = new HashMap<>();
                    applianceInstances = new HashMap<>();

                    String model = attributes.getNamedItem(MODEL).getNodeValue();
                    double price = Double.parseDouble(attributes.getNamedItem(PRICE).getNodeValue());
                    int powerConsumption = Integer.parseInt(attributes.getNamedItem(POWER_CONSUMPTION).getNodeValue());
                    double weight = Double.parseDouble(attributes.getNamedItem(WEIGHT).getNodeValue());
                    int capacity = Integer.parseInt(attributes.getNamedItem(CAPACITY).getNodeValue());
                    double depth = Double.parseDouble(attributes.getNamedItem(DEPTH).getNodeValue());
                    double height = Double.parseDouble(attributes.getNamedItem(HEIGHT).getNodeValue());
                    double width = Double.parseDouble(attributes.getNamedItem(WIDTH).getNodeValue());

                    parametersOfInstance.put(MODEL, model);
                    parametersOfInstance.put(PRICE, price);
                    parametersOfInstance.put(POWER_CONSUMPTION, powerConsumption);
                    parametersOfInstance.put(WEIGHT, weight);
                    parametersOfInstance.put(CAPACITY,capacity);
                    parametersOfInstance.put(DEPTH, depth);
                    parametersOfInstance.put(HEIGHT, height);
                    parametersOfInstance.put(WIDTH, width);

                    applianceInstances.put(new Oven(model, price, powerConsumption, weight, capacity, depth, height, width), parametersOfInstance);
                } break;
            }

            for (Map.Entry<Appliance, Map<String,Object>> parameters : applianceInstances.entrySet()) {
                int criteriaAmount = criteria.getCriteria().entrySet().size();
                for (Map.Entry<String, Object> specification : parameters.getValue().entrySet()) {
                    for (Map.Entry<String, Object> askQuality : criteria.getCriteria().entrySet()) {
                        if(specification.getKey().equals(askQuality.getKey()) && specification.getValue().equals(askQuality.getValue())) {
                            criteriaAmount--;
                            if (criteriaAmount == 0) {
                                appliances.add(parameters.getKey());

                            }
                        }
                    }
                }
            }
        }
        return appliances;
    }

    public static void addAppliance(final String applianceType, Appliance appliance) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        Document document = parseDB();

        NodeList nodes = document.getElementsByTagName(applianceType);
        Element element = document.createElement(applianceType);

        switch (applianceType) {
            case SearchCriteria.REFRIGERATOR: {

                Refrigerator refrigerator = (Refrigerator) appliance;

                element.setAttribute(MODEL, refrigerator.getModel());
                element.setAttribute(PRICE, ((Double) refrigerator.getPrice()).toString());
                element.setAttribute(POWER_CONSUMPTION, ((Integer) refrigerator.getPowerConsumption()).toString());
                element.setAttribute(WEIGHT, ((Double) refrigerator.getWeight()).toString());
                element.setAttribute(FREEZER_CAPACITY, ((Double) refrigerator.getFreezerCapacity()).toString());
                element.setAttribute(OVERALL_CAPACITY, ((Double) refrigerator.getOverallCapacity()).toString());
                element.setAttribute(HEIGHT, ((Double) refrigerator.getHeight()).toString());
                element.setAttribute(WIDTH, ((Double) refrigerator.getWidth()).toString());

            } break;

            case SearchCriteria.OVEN: {
                Oven oven = (Oven) appliance;

                element.setAttribute(MODEL, oven.getModel());
                element.setAttribute(PRICE, ((Double) oven.getPrice()).toString());
                element.setAttribute(POWER_CONSUMPTION, ((Integer) oven.getPowerConsumption()).toString());
                element.setAttribute(WEIGHT, ((Double) oven.getWeight()).toString());
                element.setAttribute(CAPACITY, ((Integer) oven.getCapacity()).toString());
                element.setAttribute(DEPTH, ((Double) oven.getDepth()).toString());
                element.setAttribute(HEIGHT, ((Double) oven.getHeight()).toString());
                element.setAttribute(WIDTH, ((Double) oven.getWidth()).toString());

            } break;

        }

        nodes.item(0).getParentNode().insertBefore(element, nodes.item(0));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(document);

        StreamResult res = new StreamResult(DB_PATH);
        transformer.transform(source, res);
    }
}