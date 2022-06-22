package LLD.DesignPatterns.Creational.AbstractFactory;

public class CloudDataFromAPI implements IngestToDatabase {
    @Override
    public void ingestData() {
        System.out.println("CLOUD : From API to database");
    }
}
