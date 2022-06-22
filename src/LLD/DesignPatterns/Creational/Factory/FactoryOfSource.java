package LLD.DesignPatterns.Creational.Factory;

// This is the main factory
public class FactoryOfSource {
    IngestToDatabase sourceData = null;

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
