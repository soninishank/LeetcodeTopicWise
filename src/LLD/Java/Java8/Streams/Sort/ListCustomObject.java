package LLD.Java.Java8.Streams.Sort;

import java.util.*;

public class ListCustomObject {

    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(176, "Roshan", "IT", 600));
        list.add(new Employee(388, "Bikash", "CIVIL", 900));
        list.add(new Employee(470, "Nishank", "DEFENCE", 500));
        list.add(new Employee(624, "Sourav", "CORE", 400));
        list.add(new Employee(176, "Prakash", "SOCIAL", 1200));
        return list;
    }

    public static void main(String[] args) {
        List<Employee> employees = getEmployees();
        // Using collection sort with lambda
        Collections.sort(employees, (o1, o2) -> (int) (o1.getSalary() - o2.getSalary())); // ascending
        Collections.sort(employees, (o1, o2) -> (int) (o2.getSalary() - o1.getSalary())); // descending
        Collections.sort(employees, ((o1, o2) -> o1.getName().compareTo(o2.getName()))); // ascending - string comparison
        Collections.sort(employees, ((o1, o2) -> o2.getName().compareTo(o1.getName()))); // descending


        // using stream API
        employees.stream().sorted((o1, o2) -> (int) (o2.getSalary() - o1.getSalary())).forEach(System.out::println);// descending
        employees.stream().sorted(Comparator.comparing(Employee::getId)).forEach(System.out::println);
        employees.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);
        employees.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);

    }
}
