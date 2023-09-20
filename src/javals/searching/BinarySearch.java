package javals.searching;

import app.utils.RuntimeTester;

/** BinarySearch */
public class BinarySearch {
    RuntimeTester run = new RuntimeTester();

    public void binarySearch(int[] arr, int target) {
        Runnable search =
                () -> {
                    int length = arr.length;
                    int low = 0;
                    int high = length - 1;
                    boolean isFound = false;

                    while (low <= high) {
                        int mid = low + (high - low) / 2;
                        if (arr[mid] == target) {
                            System.out.println("Target found at index " + mid + " .");
                            isFound = true;
                            break;
                        } else if (arr[mid] > target) {
                            high = mid - 1;
                        } else {
                            low = mid + 1;
                        }
                    }

                    if (!isFound) {
                        System.out.println("Target cannot found!");
                    }
                };
        run.test(search, "Binary Search");
    }
}