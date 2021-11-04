package by.tc.task01.main;

import by.tc.task01.dao.adder.ApplianceAdder;
import by.tc.task01.dao.adder.OvenAdder;
import by.tc.task01.dao.parser.ApplianceRepository;
import by.tc.task01.entity.Appliance;

import java.io.IOException;
import java.util.*;

import by.tc.task01.dao.util.ApplianceHandler;

import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Refrigerator;
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

//        PrintApplianceInfo.print(applianceWithParameters);

//        service.add(SearchCriteria.REFRIGERATOR, new Refrigerator("ref", SearchCriteria.REFRIGERATOR, 100,
//                100,100,100,100,180,100));
//        service.add(SearchCriteria.REFRIGERATOR, new Refrigerator("ref23", SearchCriteria.REFRIGERATOR, 1002,
//                1002,1002,1002,1002,1802,1002));


//        ApplianceXMLParser2 aaa = new ApplianceXMLParser2();
//        OvenP ovenp = new OvenP();
//        aaa.setParse(ovenp);
//        aaa.parse();
//        RefP refp = new RefP();
//        aaa.setParse(refp);
//        aaa.parse();

//        ApplianceRepository ddd = ApplianceRepository.getInstance();
        ApplianceRepository ddddd = ApplianceRepository.getInstance();

        for (Appliance appliance:ddddd.getData()) {
            System.out.println("model = " + appliance.getModel());
        }

                service.add(SearchCriteria.REFRIGERATOR, new Refrigerator("ref23", 1002,
                1002,1002,1002,1002,1802,1002));
//
//      ApplianceRepository ddd = ApplianceRepository.getInstance();
        ApplianceHandler df = ApplianceHandler.getInstance();
        df.updateDocumentForParsing();

        ApplianceRepository.getInstance();
        System.out.println("_______________________");
        for (Appliance appliance:ddddd.getData()) {
            System.out.println("model = " + appliance.getModel());
        }
        System.out.println("_______________________");
        ddddd.updateApplianceRepository();
        ApplianceRepository.getInstance();
        for (Appliance appliance:ddddd.getData()) {
            System.out.println("model = " + appliance.getModel());
        }


        OvenAdder jff = new OvenAdder();
        jff.add(new Oven("OVEN_3000", 1002,
                1002,1002,1002,1002,1802,1002));


        ApplianceAdder applianceAdder = new ApplianceAdder();
        applianceAdder.add(new Oven("OVEN_10000", 1002,
                1002,1002,1002,1002,1802,1002));

    }


}