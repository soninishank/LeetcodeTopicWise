package LLD.DesignPatterns.Creational.Builder;

// https://www.geeksforgeeks.org/builder-design-pattern/
public class BuildPatternMain {
    public static void main(String[] args) {
        // Mandatory Params
        User mandatory = new User.UserBuilder("nishank", "soni").build();
        System.out.println(mandatory);


        User build = new User.UserBuilder("nishank", "soni").address("431 el camino real").age(40).build();
        System.out.println(build);
    }
}
