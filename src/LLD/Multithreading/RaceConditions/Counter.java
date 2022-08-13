package LLD.Multithreading.RaceConditions;

public class Counter {

    private long count;

    public long incAndGet() {
        this.count++; // 3 operation - read,update and write
        return this.count;
    }

    public long get() {
        return this.count;
    }
}
