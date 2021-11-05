package by.tc.task01.dao.adder;

import by.tc.task01.entity.Appliance;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class ApplianceInvoker {
    private Addable addOven;
    private Addable addRefrigerator;

    public ApplianceInvoker() throws IOException, ParserConfigurationException, SAXException {
        addOven = new OvenAdder();
        addRefrigerator = new RefrigeratorAdder();
    }

    public void setAddOven(Addable addOven) {
        this.addOven = addOven;
    }

    public void setAddRefrigerator(Addable addRefrigerator) {
        this.addRefrigerator = addRefrigerator;
    }

    boolean addOven(Appliance appliance) throws TransformerException {
        return addOven.add(appliance);
    }

    boolean addRefrigerator(Appliance appliance) throws TransformerException {
        return addRefrigerator.add(appliance);
    }

}
