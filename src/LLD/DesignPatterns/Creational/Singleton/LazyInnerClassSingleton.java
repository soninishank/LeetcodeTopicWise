package LLD.DesignPatterns.Creational.Singleton;

// Most efficient and thread safe
public class LazyInnerClassSingleton {

    private LazyInnerClassSingleton() {

    }

    private static class SingletonHelper {
        private static final LazyInnerClassSingleton instance = new LazyInnerClassSingleton();
    }

    public static LazyInnerClassSingleton getInstance() {
        return SingletonHelper.instance;
    }
}
