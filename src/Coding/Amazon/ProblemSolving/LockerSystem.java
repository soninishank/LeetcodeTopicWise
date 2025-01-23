package Coding.Amazon.ProblemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Package {
    int width;
    int height;
    int depth;

    public Package(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    // Generate all rotations of the package (width, height, depth permutations)
    public List<int[]> getRotations() {
        return Arrays.asList(
                new int[]{width, height, depth},
                new int[]{width, depth, height},
                new int[]{height, width, depth},
                new int[]{height, depth, width},
                new int[]{depth, width, height},
                new int[]{depth, height, width}
        );
    }
}

class Locker implements Comparable<Locker> {
    int width;
    int height;
    int depth;
    boolean isOccupied;

    public Locker(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.isOccupied = false;
    }

    // Sort lockers by volume (smallest to largest) to find the best fit
    @Override
    public int compareTo(Locker other) {
        int volume1 = this.width * this.height * this.depth;
        int volume2 = other.width * other.height * other.depth;
        return Integer.compare(volume1, volume2);
    }

    // Check if the locker can fit the package in any rotation
    public boolean canFit(Package pkg) {
        if (isOccupied) return false;
        for (int[] rotation : pkg.getRotations()) {
            if (this.width >= rotation[0] && this.height >= rotation[1] && this.depth >= rotation[2]) {
                return true; // Fits in this rotation
            }
        }
        return false; // No rotation fits
    }
}

class PickupLocation {
    List<Locker> lockers;

    public PickupLocation(List<Locker> lockers) {
        this.lockers = new ArrayList<>(lockers);
        // Sort lockers by volume to optimize finding the best fit
        Collections.sort(this.lockers);
    }

    public Locker findBestLocker(Package pkg) {
        for (Locker locker : lockers) {
            if (locker.canFit(pkg)) {
                return locker; // Return the first available locker that fits
            }
        }
        return null; // No suitable locker found
    }

    public boolean assignLocker(Package pkg) {
        Locker locker = findBestLocker(pkg);
        if (locker != null) {
            locker.isOccupied = true;
            return true; // Successfully assigned a locker
        }
        return false; // No locker available
    }
}

public class LockerSystem {
    public static void main(String[] args) {
        // Define lockers
        List<Locker> lockers = Arrays.asList(
                new Locker(10, 10, 10),
                new Locker(15, 15, 15),
                new Locker(20, 20, 20),
                new Locker(5, 5, 5)
        );

        // Initialize the pickup location
        PickupLocation pickupLocation = new PickupLocation(lockers);

        // Define some packages
        Package package1 = new Package(5, 5, 5);
        Package package2 = new Package(12, 12, 8);
        Package package3 = new Package(18, 18, 18);

        // Assign lockers to packages
        System.out.println("Assigning package1: " + pickupLocation.assignLocker(package1)); // true
        System.out.println("Assigning package2: " + pickupLocation.assignLocker(package2)); // true (rotated to fit)
        System.out.println("Assigning package3: " + pickupLocation.assignLocker(package3)); // true

        // Attempt to assign another package
        Package package4 = new Package(25, 25, 25);
        System.out.println("Assigning package4: " + pickupLocation.assignLocker(package4)); // false
    }
}