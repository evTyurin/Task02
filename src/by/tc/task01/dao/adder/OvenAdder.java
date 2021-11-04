package by.tc.task01.dao.adder;

import by.tc.task01.dao.util.ApplianceHandler;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
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
    private final ApplianceHandler instance = ApplianceHandler.getInstance();
    private final Document documentForAdding = instance.getDocument();


    public OvenAdder() throws IOException, SAXException, ParserConfigurationException {}

    @Override
    public boolean add(Appliance newAppliance) throws TransformerException {

        Oven oven = (Oven) newAppliance;

        NodeList nodes = documentForAdding.getElementsByTagName(Oven.class.getSimpleName());
        Element element = documentForAdding.createElement(Oven.class.getSimpleName());

        element.setAttribute("MODEL", oven.getModel());
        element.setAttribute("PRICE", ((Double) oven.getPrice()).toString());
        element.setAttribute("POWER_CONSUMPTION", ((Integer) oven.getPowerConsumption()).toString());
        element.setAttribute("WEIGHT", ((Double) oven.getWeight()).toString());
        element.setAttribute("CAPACITY", ((Integer) oven.getCapacity()).toString());
        element.setAttribute("DEPTH", ((Double) oven.getDepth()).toString());
        element.setAttribute("HEIGHT", ((Double) oven.getHeight()).toString());
        element.setAttribute("WIDTH", ((Double) oven.getWidth()).toString());

        nodes.item(0).getParentNode().insertBefore(element, nodes.item(0));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(documentForAdding);

        StreamResult res = new StreamResult(instance.getApplianceXMLPath());

        transformer.transform(source, res);

        return false;
    }

}
