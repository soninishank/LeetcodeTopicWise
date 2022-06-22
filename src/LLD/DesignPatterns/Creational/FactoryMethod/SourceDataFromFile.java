package LLD.DesignPatterns.Creational.FactoryMethod;

public class SourceDataFromFile implements IngestToDatabase {
    @Override
    public void ingestData() {
        System.out.println("From file to DB ingesting the data");
    }
}
