package LLD.Java.StringPool;

// Two ways
// 1.new object
// 2.string literal
public class StringObject {
    public static void main(String[] args) {
        //how many object created here
        String s1 = "javatechie";
        //1 object -> new -> heap reference
        //2 object -> literal -> SCP (String constant pool area)
        String s2 = "javatechie";
        // intern method used to get reference from SCP
        System.out.println(s1.intern());
        System.out.println(s1.intern().hashCode() == s2.hashCode()); // both are pointing to same object

        //total object count 2


    }
}
