package LLD.DesignPatterns.Creational.FactoryMethod;

public class FactoryMain {
    public static void main(String[] args) {
        OnPremiseStorage onPremiseStoreService = new OnPremiseStorage();
        IngestToDatabase onPremiseStoreServiceIngestToDatabase = onPremiseStoreService.getIngestToDatabase("File");
        onPremiseStoreServiceIngestToDatabase.ingestData();
        OnCloudStorage cloudStoreService = new OnCloudStorage();
        IngestToDatabase cloudIngestionService = cloudStoreService.getIngestToDatabase("API");
        cloudIngestionService.ingestData();
    }
}
