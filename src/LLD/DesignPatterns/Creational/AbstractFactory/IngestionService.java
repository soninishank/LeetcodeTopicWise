package LLD.DesignPatterns.Creational.AbstractFactory;

public interface IngestionService {

    default void ingestDataToDatabase(String source) {
        IngestToDatabase ingestToDatabase = getIngestToDatabase(source);
        ingestToDatabase.ingestData();
    }

    IngestToDatabase getIngestToDatabase(String source);
}
