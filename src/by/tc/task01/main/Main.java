package by.tc.task01.main;

import by.tc.task01.entity.Appliance;

import java.io.IOException;
import java.util.*;


import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {

        List<Appliance> applianceWithParameters;

        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();

        Criteria criteriaOven = new Criteria(SearchCriteria.Oven.class.getSimpleName());
        criteriaOven.add(SearchCriteria.Oven.DEPTH.toString(), 60.0);
        criteriaOven.add(SearchCriteria.Oven.POWER_CONSUMPTION.toString(), 100);

        applianceWithParameters = service.find(criteriaOven);

        PrintApplianceInfo.print(applianceWithParameters);

//        service.add(SearchCriteria.REFRIGERATOR, new Refrigerator("ref", SearchCriteria.REFRIGERATOR, 100,
//                100,100,100,100,180,100));
//        service.add(SearchCriteria.REFRIGERATOR, new Refrigerator("ref23", SearchCriteria.REFRIGERATOR, 1002,
//                1002,1002,1002,1002,1802,1002));


    }


}