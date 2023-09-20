package javals.searching;

import app.utils.RuntimeTester;
/** LinearSearch */
public class LinearSearch {
    public long elapsedTime;
    RuntimeTester run = new RuntimeTester();

    public long linearSearch(int[] arr, int target) {
        System.out.println("Linear Search");
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

        return run.algorithmTakes;
    }
}