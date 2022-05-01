package LLD.CompartorComprable;

import java.util.Comparator;

public class IdComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getId() == s2.getId()) {
            // If both id are same, and you want to sort by name
            // return s1.getName().compareTo(s2.getName());
            return 0;
        } else if (s1.getId() > s2.getId()) {
            return 1;
        } else {
            return -1;
        }
    }
}
