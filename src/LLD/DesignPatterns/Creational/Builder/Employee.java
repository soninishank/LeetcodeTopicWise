package LLD.DesignPatterns.Creational.Builder;

// if your class has multiple attributes with the same type or optional when you design your class, it is time to consider the Builder Pattern.
public class Employee {
    private final String firstName;    //required
    private final String lastName;    //required
    private final int age;    //required
    private final int personalId; // required
    private final String phone;    //optional
    private final String address;    //optional
    private final String mail;    //optional


    Employee(EmployeeBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.personalId = builder.personalId;
        this.phone = builder.phone;
        this.address = builder.address;
        this.mail = builder.mail;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", personalId=" + personalId +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    public static class EmployeeBuilder {
        private final String firstName;    //required
        private final String lastName;    //required
        private final int age;    //required
        private final int personalId; // required
        private String phone;    //optional
        private String address;    //optional
        private String mail;    //optional

        public EmployeeBuilder(String firstName, String lastName, int age, int personalId) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.personalId = personalId;
        }

        public EmployeeBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public EmployeeBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public EmployeeBuilder setMail(String mail) {
            this.mail = mail;
            return this;
        }

        public Employee build() {
            // call the private constructor in the outer class
            return new Employee(this);
        }

        @Override
        public String toString() {
            return "EmployeeBuilder{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    ", personalId=" + personalId +
                    ", phone='" + phone + '\'' +
                    ", address='" + address + '\'' +
                    ", mail='" + mail + '\'' +
                    '}';
        }
    }


}