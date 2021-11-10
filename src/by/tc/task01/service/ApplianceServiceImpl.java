package by.tc.task01.service;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.Validator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ApplianceServiceImpl implements ApplianceService {

    ApplianceServiceImpl(){}

    /**
     * Find of appliances by chosen criteria
     * @param criteria
     * @return List of appliances filled using criteria
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws TransformerException
     */

    @Override
    public List<Appliance> find(Criteria criteria) {
        if (!Validator.criteriaValidator(criteria)) {
            return Collections.EMPTY_LIST;
        }
        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();
        return applianceDAO.find(criteria);
    }

    /**
     * Add properties of instance of Appliance to XML file
     * @param appliance
     * @return true if appliance added successfully
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws TransformerException
     * @throws SAXException
     */

    @Override
    public boolean add(Appliance appliance) {
        if (Validator.applianceValidator(appliance)) {
            DAOFactory factory = DAOFactory.getInstance();
            ApplianceDAO applianceDAO = factory.getApplianceDAO();
            return applianceDAO.add(appliance);
        } else {
            return false;
        }
    }
}
