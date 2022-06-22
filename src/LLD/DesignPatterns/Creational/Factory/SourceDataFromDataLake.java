package LLD.DesignPatterns.Creational.Factory;

public class SourceDataFromDataLake implements IngestToDatabase{
    @Override
    public void ingestData() {
        System.out.println("From Data lake to database");
    }
}
