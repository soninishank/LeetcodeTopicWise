package LLD.Java.ParentChildOverride;

public class ChildWithoutMethod extends Parent {

    // You will not get any compilation error
    // Firstly it will check in child class method is present or not
    // if not present than it will call parent class method
    public static void main(String[] args) {
        Parent parent = new ChildWithoutMethod();
        parent.m1();
    }
}
