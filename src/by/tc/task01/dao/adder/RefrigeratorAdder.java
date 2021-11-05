package by.tc.task01.dao.adder;

import by.tc.task01.dao.util.ApplianceHandlerUtil;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.criteria.SearchCriteria;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

public class RefrigeratorAdder implements Addable {
    private ApplianceHandlerUtil instance;
    private Document document;

    public RefrigeratorAdder() throws IOException, SAXException, ParserConfigurationException {
        instance = ApplianceHandlerUtil.getInstance();
        document = instance.getDocument();
    }

    @Override
    public boolean add(Appliance appliance) throws TransformerException {
        boolean flag = setNodeLiStElement(appliance);
        if (flag) {
            writeToXML();
        }

        return flag;
    }

    private boolean setNodeLiStElement(Appliance appliance) {
        Refrigerator refrigerator = (Refrigerator) appliance;

        NodeList nodes = document.getElementsByTagName(Refrigerator.class.getSimpleName());
        Element element = document.createElement(Refrigerator.class.getSimpleName());

        element.setAttribute(SearchCriteria.Appliance.MODEL.toString(), refrigerator.getModel());
        element.setAttribute(SearchCriteria.Appliance.PRICE.toString(), ((Double) refrigerator.getPrice()).toString());
        element.setAttribute(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString(), ((Integer) refrigerator.getPowerConsumption()).toString());
        element.setAttribute(SearchCriteria.Refrigerator.WEIGHT.toString(), ((Double) refrigerator.getWeight()).toString());
        element.setAttribute(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString(), ((Double) refrigerator.getFreezerCapacity()).toString());
        element.setAttribute(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString(), ((Double) refrigerator.getOverallCapacity()).toString());
        element.setAttribute(SearchCriteria.Refrigerator.HEIGHT.toString(), ((Double) refrigerator.getHeight()).toString());
        element.setAttribute(SearchCriteria.Refrigerator.WIDTH.toString(), ((Double) refrigerator.getWidth()).toString());

        nodes.item(0).getParentNode().insertBefore(element, nodes.item(0));

        return element.hasAttributes();
    }

    private void writeToXML() throws TransformerException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(document);

        StreamResult res = new StreamResult(instance.getApplianceXMLPath());

        transformer.transform(source, res);
    }

}