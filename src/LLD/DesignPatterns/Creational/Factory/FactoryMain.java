package LLD.DesignPatterns.Creational.Factory;

public class FactoryMain {
    public static void main(String[] args) {
        IngestionService ingestionService = new IngestionService();
        ingestionService.ingestDataToDatabase("File");
    }
}
