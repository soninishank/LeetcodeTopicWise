package LLD.Java.Immutable;

// immutable class
// final - no one can extend this
public final class Employee {
    private final String name;
    private final int empId;
    private final Company company;

    /*
    all argument constructor so that all object fields can be
    initialized at the time of object creation only. (Step 2)
     */
    public Employee(String name, int empId, Company company) {
        this.name = name;
        this.empId = empId;
        /*
        If we use 'company' reference to assign the value to 'company'  field of 'Employee' class then using the reference which is passed
        to this constructor , one can change 'companyName' or 'companySize' fields of the reference passed to constructor as 'Company' class is mutable class. (Step 4)
        //this.company = company; //do not use this as 'company' can be modified
         */
        this.company = new Company(company.getCompanyName(), company.getCompanySize());
        //here new object of 'Company' class is created using value of object passed to constructor
    }

    /*
    only getters so that no one can change object fields using
    setter methods for object fields (Step 1)
     */
    public String getName() {
        return name;
    }

    public int getEmpId() {
        return empId;
    }

    public Company getCompany() {
        /*
        returning clone object of 'company' field of 'Employee' class so no one can
        modify the fields of 'company' using the reference returned by getCompany().
        (Step 5)
         */
        //return company;//do not use this as using 'company' reference its fields can be modified .

        return new Company(company.getCompanyName(), company.getCompanySize());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", empId=" + empId +
                ", company=" + company +
                '}';
    }
}
