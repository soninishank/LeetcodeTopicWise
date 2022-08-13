package LLD.Java.MethodHiding;

public class MainMethodHiding {
    public static void main(String[] args) {
        ParentMethod parentMethod = new ParentMethod();
        parentMethod.printMessage();

        ParentMethod childMethod = new ChildMethod();
        childMethod.printMessage();

        ChildMethod childMethod1 = new ChildMethod();
        childMethod1.printMessage();
    }
}
