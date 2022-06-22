package LLD.DesignPatterns.Creational.FactoryMethod;

public class CloudDataFromAPI implements IngestToDatabase {
    @Override
    public void ingestData() {
        System.out.println("CLOUD : From API to database");
    }
}
