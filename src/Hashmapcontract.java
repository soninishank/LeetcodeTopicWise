import java.util.Objects;

public class Hashmapcontract {


}

class Emp {
    String name;
    int rollNo;

    public Emp(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Emp)) return false;
        Emp emp = (Emp) o;
        return rollNo == emp.rollNo && Objects.equals(name, emp.name);
    }


    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                '}';
    }
}
