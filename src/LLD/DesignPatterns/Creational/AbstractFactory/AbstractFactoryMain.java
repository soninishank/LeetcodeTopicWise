package LLD.DesignPatterns.Creational.AbstractFactory;

public class AbstractFactoryMain {
    public static void main(String[] args) {

        IngestionService storageObject = new FactoryOfFactory_AbstractFactory().getStorageService("ON_PREMISE");
        storageObject.ingestDataToDatabase("File");

        IngestionService cloud = new FactoryOfFactory_AbstractFactory().getStorageService("CLOUD");
        cloud.ingestDataToDatabase("API");
    }
}
