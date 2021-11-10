package by.tc.task01.dao.parser;

import by.tc.task01.dao.util.ApplianceHandlerUtil;
import by.tc.task01.entity.Appliance;
import org.w3c.dom.Document;
import java.util.ArrayList;
import java.util.List;

public class ApplianceXMLParser {

    private Parsable parse;
    private List<Appliance> appliances;
    private final ApplianceHandlerUtil instance;

    public void setParse(Parsable parse) {
        this.parse = parse;
    }

    ApplianceXMLParser()  {
        appliances = new ArrayList<>();
        instance = ApplianceHandlerUtil.getInstance();
    }

    public List<Appliance> parse() {
        Document documentForParsing = instance.getDocument();
        setParse(new OvenParser(documentForParsing));
        appliances = parse.parseApplianceXML();

        setParse(new RefrigeratorParser(documentForParsing));
        appliances.addAll(parse.parseApplianceXML());

        return appliances;
    }

}