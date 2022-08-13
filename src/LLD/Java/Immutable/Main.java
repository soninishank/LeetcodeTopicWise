package LLD.Java.Immutable;

public class Main {

    public static void main(String[] args) {

        //creating 'Company' object
        Company company = new Company("Medium", 50);

        //creating 'Employee' object
        Employee employee = new Employee("Ram", 1000, company);
        System.out.println("Employee Object is : " + employee);

    }
}
