package javals.searching;

import app.utils.RuntimeTester;
/** LinearSearch */
public class LinearSearch {
    RuntimeTester run = new RuntimeTester();

    public void linearSearch(int[] arr, int target) {
        Runnable search =
                () -> {
                    int length = arr.length;
                    boolean isFound = false;
                    for (int i = 0; i < length; i++) {
                        if (target == arr[i]) {
                            System.out.println("Target found at index " + i + ".");
                            isFound = true;
                            break;
                        }
                    }

                    if (!isFound) {
                        System.out.println("Target cannot found!");
                    }
                };

        run.test(search, "Linear Search");
    }
}