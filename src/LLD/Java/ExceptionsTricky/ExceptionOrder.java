package LLD.Java.ExceptionsTricky;

public class ExceptionOrder {
    public static void main(String[] args) {
        try {
            System.out.println(10 / 0);
        } catch (ArithmeticException ae) { // this is the child class
            System.out.println(ae.getMessage());
        } catch (Exception ex) { // exception is the super class
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("finally");
        }
    }

    //      try {
    //            System.out.println(10 / 0);
    //        } catch (Exception ex) { // parent class will never be a first statement
    //            System.out.println(ex.getMessage());
    //        } catch (ArithmeticException ae) { // it will give CTE
    //                System.out.println(ae.getMessage());
    //        }finally {
    //            System.out.println("finally");
    //        }
}
