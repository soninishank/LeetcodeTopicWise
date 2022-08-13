package Coding.Recursion;

import java.util.Arrays;

public class NoOfRoomsKeys {

    private void getArray(int days, int rooms) {
        int[] roomNo = new int[rooms + 1];// starting index 0 to 6
        for (int i = 1; i <= Math.min(days, rooms); i++) {
            if (i == 1) {
                Arrays.fill(roomNo, 1);
            } else {
                for (int m = i; m < roomNo.length; m += i) {
                    if (m % i == 0) {
                        roomNo[m] = roomNo[m] ^ 1;
                    }
                }
                System.out.println("For room no " + i + "  === " + Arrays.toString(roomNo));
            }
        }
    }

    public static void main(String[] args) {
        int days = 15;
        int rooms = 15;
        new NoOfRoomsKeys().getArray(days, rooms);
    }


}


// 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0
// 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0