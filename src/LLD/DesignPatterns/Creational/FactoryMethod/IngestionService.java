package LLD.DesignPatterns.Creational.FactoryMethod;

public interface IngestionService {

    default void ingestDataToDatabase(String source) {
        IngestToDatabase ingestToDatabase = getIngestToDatabase(source);
        ingestToDatabase.ingestData();
    }

    IngestToDatabase getIngestToDatabase(String source);
}
