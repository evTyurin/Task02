package by.tc.task01.main;

//import by.tc.task01.dao.searcher.OvenSearcher;
import by.tc.task01.dao.util.ApplianceHandlerUtil;
import by.tc.task01.entity.Appliance;

import java.io.IOException;
import java.util.*;

import by.tc.task01.entity.Oven;
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
        ApplianceHandlerUtil.setPathToXML("resources/appliances.xml");

        Criteria criteriaOven = new Criteria(SearchCriteria.Oven.class.getSimpleName());
        criteriaOven.add(SearchCriteria.Oven.DEPTH.toString(), 60.0);
        criteriaOven.add(SearchCriteria.Oven.POWER_CONSUMPTION.toString(), 100);

        applianceWithParameters = service.find(criteriaOven);

        PrintApplianceInfo.print(applianceWithParameters);

        service.add(new Oven("Zanussi", 100, 250,10,50,100,180,120));

        Criteria criteriaRefrigerator = new Criteria(SearchCriteria.Refrigerator.class.getSimpleName());
        criteriaRefrigerator.add(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString(), 300.0);
        criteriaRefrigerator.add(SearchCriteria.Refrigerator.WEIGHT.toString(), 30.0);

        applianceWithParameters = service.find(criteriaRefrigerator);

        PrintApplianceInfo.print(applianceWithParameters);


        ///////////////////////////////////


//        ApplianceDAOImpl dfsdf = new ApplianceDAOImpl();
//        dfsdf.add(new Oven("hiii", 100, 250,10,50,100,180,120));

//        try {
//            IOException oi = new IOException();
//            oi.initCause(new IOException("Actual cause"));
//            throw oi;
//        } catch (IOException oi) {
//            System.out.println(oi);
//            System.out.println(oi.getCause());
//            oi.initCause((new IOException("dfd")));
//
//            System.out.println(oi);
//
//            throw new RuntimeException("df", new IOException() );
//        }
//
//        public void TRExe (IOException e) {
//            e.initCause(e);
//            throw new RuntimeException("df", e);
//        }
//
//        try {
//            IOException fdfsf = new IOException();
//            fdfsf.initCause(fdfsf);
//            throw fdfsf;
//
//        } catch (IOException eee) {
//            throw new RuntimeException("df", eee);
//        }

//        DAOExeption daoExeption = new DAOExeption();
//        daoExeption.exept(new IOException());

//        try {
//            IOException oi = new IOException();
//            oi.initCause(new IOException("Actual cause"));
//            throw oi;
//        } catch (IOException oi) {
//            System.out.println(oi);
//            System.out.println(oi.getCause());
//            oi.initCause((new IOException("dfd")));
//
//            System.out.println(oi);

//            throw new RuntimeException("df", new IOException() );
//        }

    }
}