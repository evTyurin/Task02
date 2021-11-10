package by.tc.task01.service;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final ApplianceService applianceService = new ApplianceServiceImpl();

    private ServiceFactory() {}

    public ApplianceService getApplianceService() {
        return applianceService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
