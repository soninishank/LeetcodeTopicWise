package LLD.Java.Java8.Streams.Sort;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MapCustomObject {

    public static void main(String[] args) {
        // For TreeMap - it's mandatory to pass the comparator whenever you are using a custom object
        Map<Employee, Integer> employeeMap = new TreeMap<>((o1, o2) -> (int) (o1.getSalary() - o2.getSalary()));
        employeeMap.put(new Employee(176, "Roshan", "IT", 600), 60);
        employeeMap.put(new Employee(388, "Bikash", "CIVIL", 900), 90);
        employeeMap.put(new Employee(470, "Bimal", "DEFENCE", 500), 50);
        employeeMap.put(new Employee(624, "Sourav", "CORE", 400), 40);
        employeeMap.put(new Employee(284, "Prakash", "SOCIAL", 1200), 120);

        System.out.println(employeeMap);

        employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary))).forEach(System.out::println); // ascending
        employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary).reversed())).forEach(System.out::println); // descending
        //  employeeMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing()));

    }
}
