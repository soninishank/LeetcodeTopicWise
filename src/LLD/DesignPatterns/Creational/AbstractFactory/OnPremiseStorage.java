package LLD.DesignPatterns.Creational.AbstractFactory;

public class OnPremiseStorage implements IngestionService {
    IngestToDatabase sourceData = null;

    @Override
    public IngestToDatabase getIngestToDatabase(String source) {
        if (source.equals("File")) {
            sourceData = new SourceDataFromFile();
        } else if (source.equals("API")) {
            sourceData = new SourceDataFromAPI();
        } else {
            sourceData = new SourceDataFromDataLake();
        }
        return sourceData;
    }
}
