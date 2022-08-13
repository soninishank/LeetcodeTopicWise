package LLD.DesignPatterns.Creational.Singleton;

// We can make constructor as private. So that We can not create an
//object outside of the class.
public class LazySingletonDoubleChecking {
    private LazySingletonDoubleChecking() {
    }

    private static LazySingletonDoubleChecking instance;

    // static factory method
    // to avoid race condition on multithreading - use synchronized
    public static LazySingletonDoubleChecking getInstance() {
        if (instance == null) {
            // synchronized block
            synchronized (LazySingletonDoubleChecking.class) {
                if (instance == null) {
                    instance = new LazySingletonDoubleChecking();
                }
            }
        }
        return instance;
    }
}
