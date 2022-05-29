package LLD.DesignPatterns.Singleton;

public class EagerSingleton {

    private EagerSingleton() {
    }

    private static final EagerSingleton instance = new EagerSingleton();

    // it can have performance issues

    public static EagerSingleton getInstance() {
        return instance;
    }
}
