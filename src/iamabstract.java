public abstract class iamabstract {

    void m1() {
        System.out.println("nishank");
    }
}

class Test {
    public static void main(String[] args) {
        iamabstract iamabstract = new iamabstract() {};
        iamabstract.m1();
    }
}