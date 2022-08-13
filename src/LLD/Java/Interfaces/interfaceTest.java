package LLD.Java.Interfaces;

import java.util.Collection;

public interface interfaceTest {


    default String m1() {

        return "nishank";
    }

    void m2();

    static String m21() {
        return "nisjan";
    }
}
