package LLD.Java.ExceptionHierarchy;

public class Child extends Parent {


    // There is no compile time exception
    @Override
    public void m1() {
        System.out.println("child m1()");
    }

    @Override
    public void childThrowingException() throws Exception {
        System.out.println("child is throwing an exception");
    }
}


// If parent is throwing exception than child does not need to handle the exception - for child its optional
// If child is throwing exception than parent must need to handle the exception