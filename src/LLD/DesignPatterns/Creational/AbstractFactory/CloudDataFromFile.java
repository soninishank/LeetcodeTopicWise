package LLD.DesignPatterns.Creational.AbstractFactory;

public class CloudDataFromFile implements IngestToDatabase {
    @Override
    public void ingestData() {
        System.out.println("CLOUD : From File to database");
    }
}
