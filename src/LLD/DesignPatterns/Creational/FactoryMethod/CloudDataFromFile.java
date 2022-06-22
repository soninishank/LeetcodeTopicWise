package LLD.DesignPatterns.Creational.FactoryMethod;

public class CloudDataFromFile implements IngestToDatabase {
    @Override
    public void ingestData() {
        System.out.println("CLOUD : From File to database");
    }
}
