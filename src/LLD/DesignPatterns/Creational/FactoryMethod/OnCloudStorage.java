package LLD.DesignPatterns.Creational.FactoryMethod;

public class OnCloudStorage implements IngestionService {

    IngestToDatabase sourceData = null;

    @Override
    public IngestToDatabase getIngestToDatabase(String source) {
        if (source.equals("File")) {
            sourceData = new CloudDataFromFile();
        } else if (source.equals("API")) {
            sourceData = new CloudDataFromAPI();
        }
        return sourceData;
    }
}
