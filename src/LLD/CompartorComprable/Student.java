package LLD.CompartorComprable;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

// Single sorting sequence
// Sorting students by id
// You have written code for sort only by name , if you get a requirement to sort by name , again you need to
// write the code , it's not dynamic
public class Student implements Comparable<Student> {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Student student) {
        if (this.id == student.id) {
            return 0;
        } else if (this.id > student.id) {
            return 1;
        } else {
            return -1;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public static void main(String[] args) {
        List<Student> list = Arrays.asList(new Student(100, "first"), new Student(109, "last"),
                new Student(105, "mid"),
                new Student(90, "dance"));

        System.out.println("Without sorting by comparable " + list);

        // For sorting - comparable
        Collections.sort(list);
        System.out.println("After sorting with comparable " + list);

        // For sorting - comparator
        Collections.sort(list, new NameComparator());
        System.out.println("After sorting with comparator " + list);

    }
}
