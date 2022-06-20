package LLD.Java.Java8.Streams.MapFlatMap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Map {

    public static List<Customer> getAll() {
        return Stream.of(
                new Customer(101, "john", "john@gmail.com", Arrays.asList("397937955", "21654725")),
                new Customer(102, "smith", "smith@gmail.com", Arrays.asList("89563865", "2487238947")),
                new Customer(103, "peter", "peter@gmail.com", Arrays.asList("38946328654", "3286487236")),
                new Customer(104, "kely", "kely@gmail.com", Arrays.asList("389246829364", "948609467"))
        ).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // Data Transformation - getAllEmails
        // Mapping logic - 1 to 1 mapping - 1 customer have 1 email id
        List<String> emailList = getAll().stream().map(customer -> customer.getEmail()).collect(Collectors.toList());
        List<List<String>> phoneNumber = getAll().stream().map(Customer::getPhoneNumbers).collect(Collectors.toList());

        // FlatMap - it will take input as stream
        List<String> phoneNos = getAll().stream().flatMap(customer -> customer.getPhoneNumbers().stream()).collect(Collectors.toList());// get flattened data
        System.out.println(phoneNos);
    }
}
