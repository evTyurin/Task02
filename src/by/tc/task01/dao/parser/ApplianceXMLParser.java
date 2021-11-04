package by.tc.task01.dao.parser;

import by.tc.task01.dao.util.ApplianceHandler;
import by.tc.task01.entity.Appliance;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApplianceXMLParser {

    private Document documentForParsing;
    private Parseble parse;
    private List<Appliance> appliances;
    private ApplianceHandler instance;

    public void setParse(Parseble parse) {
        this.parse = parse;
    }

    public ApplianceXMLParser()  {
        appliances = new ArrayList<>();
        instance = ApplianceHandler.getInstance();
    }

    public List<Appliance> parse()  throws ParserConfigurationException, IOException, SAXException{

        documentForParsing = instance.getDocument();
        setParse(new OvenParser(documentForParsing));
        appliances = parse.parseApplianceXML();

        setParse(new RefrigeratorParser(documentForParsing));
        appliances.addAll(parse.parseApplianceXML());

        return appliances;
    }

}