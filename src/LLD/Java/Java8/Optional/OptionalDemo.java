package LLD.Java.Java8.Optional;

import LLD.Java.Java8.Streams.MapFlatMap.Customer;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static LLD.Java.Java8.Streams.MapFlatMap.Map.getAll;

public class OptionalDemo {


    public static void main(String[] args) throws Exception {

        Customer customer = new Customer(101, "john", null, Arrays.asList("397937955", "21654725"));

        //empty
        //of
        //ofNullable
        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

        // ofNullable - will not throw an exception for the null object
        Optional<String> emailOptional = Optional.ofNullable(customer.getEmail());
        System.out.println(emailOptional);
        if (emailOptional.isPresent()) { // isPresent for null check
            System.out.println(emailOptional);
        }
        System.out.println(emailOptional.orElse("email is empty so handling that"));

        Optional<String> name = Optional.ofNullable(customer.getName());
        System.out.println(name.get()); // to get a value

        // of - will throw NullPointerException
        Optional<String> email = Optional.of(customer.getEmail());
        System.out.println(email);


    }
}
