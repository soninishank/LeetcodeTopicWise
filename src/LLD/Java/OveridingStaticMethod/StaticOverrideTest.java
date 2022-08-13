package LLD.Java.OveridingStaticMethod;

public class StaticOverrideTest {

    public static void main(String[] args) {
        Parent p = new Parent();
        Parent.name();   // should call static method from super class (Parent)
        // because type of reference variable
        // p is Parent

        p = new Child();
        Parent.name();  // as per overriding rules this should call to child's static
        // overridden method. Since static method can not be overridden
        // , it will call parent static method
        // because Type of p is Parent.

        Child c = new Child();
        Child.name();  // will call child static method because static method
        // get called by type of Class
    }
}
