package Coding.PriorityQueue.K;

// https://www.youtube.com/watch?v=ooLKYx1TlSE
// For smallest = k is same
// For largest = pass k as - arr.length - k + 1
public class QuickSelectAlgorithm {

    // we are sorting the array till the kth element
    private int getKthSmallestElement(int[] arr, int k, int low, int high) {
        int pivotPoint = getPivotPoint(arr, low, high);
        if (pivotPoint == k - 1) {
            return arr[pivotPoint];
        } else if (pivotPoint < k - 1) {
            return getKthSmallestElement(arr, k, pivotPoint + 1, high); // look on right side of pivot point
        } else {
            return getKthSmallestElement(arr, k, low, pivotPoint - 1);
        }
    }

    private int getPivotPoint(int[] arr, int low, int high) {
        int pivotElement = arr[high];
        int index = low; // it starts from lower index - index
        for (int i = low; i <= high; i++) {
            // all are getting stored in left side of pivotElement after swap
            if (arr[i] < pivotElement) {
                // swap
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index++;
            }
        }
        // after the loop move pivotElement to index
        int temp = arr[index];
        arr[index] = arr[high];
        arr[high] = temp;
        return index;
    }


    public static void main(String[] args) {
        int arr[] = {4, 5, 10, 11, 1, 3, 19, 8, 7};
        int kthSmallestElement = new QuickSelectAlgorithm().getKthSmallestElement(arr, 2, 0, arr.length - 1);
        System.out.println(kthSmallestElement);
    }
}
