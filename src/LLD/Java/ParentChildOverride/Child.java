package LLD.Java.ParentChildOverride;

public class Child extends Parent {

    @Override
    public void m1() {
        System.out.println("child m1()");
    }

    // we are not creating an object of parent , with the reference of parent we are creating the object of child
    public static void main(String[] args) {
        Parent parent = new Child();
        parent.m1(); // child m1()
    }
}
