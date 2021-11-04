package by.tc.task01.dao.adder;

import by.tc.task01.dao.util.ApplianceHandler;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class RefrigeratorAdder implements Addable {
    ApplianceHandler instance = ApplianceHandler.getInstance();
    ApplianceHandler inst = ApplianceHandler.getInstance();
    Document document = inst.getDocument();


    public RefrigeratorAdder() throws IOException, SAXException, ParserConfigurationException {}

    @Override
    public boolean add(Appliance newAppliance) throws TransformerException {

        Refrigerator refrigerator = (Refrigerator) newAppliance;

        NodeList nodes = document.getElementsByTagName(Refrigerator.class.getSimpleName());
        Element element = document.createElement(Refrigerator.class.getSimpleName());

        element.setAttribute("MODEL", refrigerator.getModel());
        element.setAttribute("PRICE", ((Double) refrigerator.getPrice()).toString());
        element.setAttribute("POWER_CONSUMPTION", ((Integer) refrigerator.getPowerConsumption()).toString());
        element.setAttribute("WEIGHT", ((Double) refrigerator.getWeight()).toString());
        element.setAttribute("FREEZER_CAPACITY", ((Double) refrigerator.getFreezerCapacity()).toString());
        element.setAttribute("OVERALL_CAPACITY", ((Double) refrigerator.getOverallCapacity()).toString());
        element.setAttribute("HEIGHT", ((Double) refrigerator.getHeight()).toString());
        element.setAttribute("WIDTH", ((Double) refrigerator.getWidth()).toString());

        nodes.item(0).getParentNode().insertBefore(element, nodes.item(0));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(document);

        StreamResult res = new StreamResult(instance.getApplianceXMLPath());

        transformer.transform(source, res);

        return false;
    }

}