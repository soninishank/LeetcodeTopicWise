package LLD.DesignPatterns.Creational.Factory;

public class IngestionService {
    private FactoryOfSource factoryOfSource;

    public IngestionService() {
        factoryOfSource = new FactoryOfSource();
    }

    public void ingestDataToDatabase(String source) {
        IngestToDatabase ingestToDatabase = factoryOfSource.getIngestToDatabase(source);
        ingestToDatabase.ingestData();
    }
}
