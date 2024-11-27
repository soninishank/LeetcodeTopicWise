package Coding.Amazon.ProblemSolving;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Define the dimensions of the lockers and packages
class Dimensions implements Comparable<Dimensions> {
    int width;
    int height;

    public Dimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean canFit(Dimensions other) {
        return this.width >= other.width && this.height >= other.height;
    }

    @Override
    public int compareTo(Dimensions other) {
        if (this.width != other.width) {
            return Integer.compare(this.width, other.width);
        }
        return Integer.compare(this.height, other.height);
    }

    @Override
    public String toString() {
        return "Dimensions{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}

// Define a locker in the pickup location
class Locker {
    int id;
    Dimensions dimensions;
    boolean isOccupied;

    public Locker(int id, Dimensions dimensions) {
        this.id = id;
        this.dimensions = dimensions;
        this.isOccupied = false;
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

    @Override
    public String toString() {
        return "Locker{" +
                "id=" + id +
                ", dimensions=" + dimensions +
                ", isOccupied=" + isOccupied +
                '}';
    }
}

// The pickup location containing a set of lockers
class PickupLocation {
    List<Locker> lockers;

    public PickupLocation(List<Locker> lockers) {
        this.lockers = lockers;
        // Sort lockers by size to enable efficient searching
        lockers.sort(Comparator.comparing(l -> l.dimensions));
    }

    // Find the smallest locker that can fit the package
    public Locker findBestLocker(Dimensions packageDimensions) {
        for (Locker locker : lockers) {
            if (locker.isAvailable() && locker.dimensions.canFit(packageDimensions)) {
                return locker;
            }
        }
        return null; // No suitable locker found
    }
}

public class LockerSystem {
    public static void main(String[] args) {
        // Initialize lockers
        List<Locker> lockers = new ArrayList<>();
        lockers.add(new Locker(1, new Dimensions(10, 10)));
        lockers.add(new Locker(2, new Dimensions(15, 15)));
        lockers.add(new Locker(3, new Dimensions(5, 5)));
        lockers.add(new Locker(4, new Dimensions(20, 20)));

        PickupLocation pickupLocation = new PickupLocation(lockers);

        // Test cases
        Dimensions package1 = new Dimensions(5, 5);
        Dimensions package2 = new Dimensions(12, 12);
        Dimensions package3 = new Dimensions(25, 25); // Too large for any locker

        Locker bestLocker1 = pickupLocation.findBestLocker(package1);
        if (bestLocker1 != null) {
            System.out.println("Best locker for package1: " + bestLocker1);
            bestLocker1.isOccupied = true;
        } else {
            System.out.println("No locker available for package1.");
        }

        Locker bestLocker2 = pickupLocation.findBestLocker(package2);
        if (bestLocker2 != null) {
            System.out.println("Best locker for package2: " + bestLocker2);
            bestLocker2.isOccupied = true;
        } else {
            System.out.println("No locker available for package2.");
        }

        Locker bestLocker3 = pickupLocation.findBestLocker(package3);
        if (bestLocker3 != null) {
            System.out.println("Best locker for package3: " + bestLocker3);
            bestLocker3.isOccupied = true;
        } else {
            System.out.println("No locker available for package3.");
        }
    }
}
