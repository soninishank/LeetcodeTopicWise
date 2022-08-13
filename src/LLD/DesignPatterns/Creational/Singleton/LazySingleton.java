package LLD.DesignPatterns.Creational.Singleton;

// https://www.youtube.com/watch?v=rSZIRsB0YlQ
// to prevent the class from creating multiple object using cloning , reflection API , serialization
public class LazySingleton {
    // so that other class can access directory
    private static LazySingleton instance;

    private LazySingleton() {
        if (instance != null) {
            throw new IllegalStateException("object can't be create using reflection");
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    protected Object readResolve() {
        return instance;
    }

    // static factory method
    // to avoid race condition on multithreading - use synchronized
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            return instance = new LazySingleton();
        } else {
            return instance;
        }
    }

}

