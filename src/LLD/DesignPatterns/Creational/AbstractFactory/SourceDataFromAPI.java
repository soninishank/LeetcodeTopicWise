package LLD.DesignPatterns.Creational.AbstractFactory;

public class SourceDataFromAPI implements IngestToDatabase {
    @Override
    public void ingestData() {
        System.out.println("From API to database");
    }
}
