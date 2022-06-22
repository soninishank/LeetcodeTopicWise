package LLD.DesignPatterns.Creational.AbstractFactory;

public class FactoryOfFactory_AbstractFactory {
    IngestionService ingestionService = null;

    public IngestionService getStorageService(String storageType) {
        if (storageType.equals("ON_PREMISE")) {
            ingestionService = new OnPremiseStorage();
        } else if (storageType.equals("CLOUD")) {
            ingestionService = new OnCloudStorage();
        }
        return ingestionService;
    }
}
