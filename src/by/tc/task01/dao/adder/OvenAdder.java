package by.tc.task01.dao.adder;

import by.tc.task01.dao.util.ApplianceHandlerUtil;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
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

public class OvenAdder implements Addable {
    private final ApplianceHandlerUtil instance;
    private final Document documentForAdding;

    public OvenAdder() throws IOException, SAXException, ParserConfigurationException {
        instance = ApplianceHandlerUtil.getInstance();
        documentForAdding = instance.getDocument();
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
        Oven oven = (Oven) appliance;

        NodeList nodes = documentForAdding.getElementsByTagName(Oven.class.getSimpleName());
        Element element = documentForAdding.createElement(Oven.class.getSimpleName());

        element.setAttribute(SearchCriteria.Appliance.MODEL.toString(), oven.getModel());
        element.setAttribute(SearchCriteria.Appliance.PRICE.toString(), ((Double) oven.getPrice()).toString());
        element.setAttribute(SearchCriteria.Oven.POWER_CONSUMPTION.toString(), ((Integer) oven.getPowerConsumption()).toString());
        element.setAttribute(SearchCriteria.Oven.WEIGHT.toString(), ((Double) oven.getWeight()).toString());
        element.setAttribute(SearchCriteria.Oven.CAPACITY.toString(), ((Integer) oven.getCapacity()).toString());
        element.setAttribute(SearchCriteria.Oven.DEPTH.toString(), ((Double) oven.getDepth()).toString());
        element.setAttribute(SearchCriteria.Oven.HEIGHT.toString(), ((Double) oven.getHeight()).toString());
        element.setAttribute(SearchCriteria.Oven.WIDTH.toString(), ((Double) oven.getWidth()).toString());

        nodes.item(0).getParentNode().insertBefore(element, nodes.item(0));

        return element.hasAttributes();
    }

    private void writeToXML() throws TransformerException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(documentForAdding);

        StreamResult result = new StreamResult(instance.getApplianceXMLPath());

        transformer.transform(source, result);
    }

}
