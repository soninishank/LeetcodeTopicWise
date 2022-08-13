public abstract class iamabstract1 {
    int name;

    public iamabstract1(int name) {
        this.name = name;
    }

    void m1() {
        System.out.println("i am checkinh");
        System.out.println("name " + name);
    }
}

class Test111 extends iamabstract1 {

    public Test111() {
        super(12);
    }

    public static void main(String[] args) {
        Test111 test111 = new Test111();
        test111.m1();
    }
}
