package LLD.DesignPatterns.Singleton;

public class SingletonTest {

    public static void main(String[] args) {
        // 2101440631
        //2101440631
        // will return the same hashcode
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        System.out.println(eagerSingleton.hashCode());
        EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
        System.out.println(eagerSingleton1.hashCode());

        System.out.println();

        LazySingleton instance = LazySingleton.getInstance();
        System.out.println(instance.hashCode());
        LazySingleton instance1 = LazySingleton.getInstance();
        System.out.println(instance1.hashCode());
        System.out.println();

        LazySingletonDoubleChecking instance11 = LazySingletonDoubleChecking.getInstance();
        System.out.println(instance11.hashCode());
        LazySingletonDoubleChecking instance12 = LazySingletonDoubleChecking.getInstance();
        System.out.println(instance12.hashCode());

        System.out.println();
        LazyInnerClassSingleton innerClassSingleton = LazyInnerClassSingleton.getInstance();
        System.out.println(innerClassSingleton.hashCode());
        LazyInnerClassSingleton innerClassSingleton1 = LazyInnerClassSingleton.getInstance();
        System.out.println(innerClassSingleton1.hashCode());
    }
}
