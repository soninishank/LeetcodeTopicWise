package LLD.DesignPatterns.Fliter.Model;

public class Laptop {
    private final Integer id;
    private final String hardDisk;
    private final String processor;
    private final String ram;
    private final String operatingSystem;
    private final String screenSize;

    public Laptop(Integer id, String hardDisk, String processor, String ram, String operatingSystem, String screenSize) {
        this.id = id;
        this.hardDisk = hardDisk;
        this.processor = processor;
        this.ram = ram;
        this.operatingSystem = operatingSystem;
        this.screenSize = screenSize;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public String getProcessor() {
        return processor;
    }

    public String getRam() {
        return ram;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void prettyPrint() {
        System.out.println("ID = " + id + ";\t" + "Hard Disk = " + hardDisk + ";\t" + "Processor = " + processor + ";\t" + "RAM = " + ram + ";\t" + "OS = " + operatingSystem + ";\t" + "Screen Size = " + screenSize);
    }
}
