package by.tc.task01.dao;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final ApplianceDAO applianceDAO = new ApplianceDAOImpl();

    private DAOFactory() {};

    public ApplianceDAO getApplianceDAO() {
        return applianceDAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}