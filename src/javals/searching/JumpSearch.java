package javals.searching;

import app.utils.RuntimeTester;

public class JumpSearch {
    RuntimeTester run;

    public JumpSearch() {
        run = new RuntimeTester();
    }

    public double jumpSearch(int[] arr, int target) {
        System.out.println("Jump Search");
        Runnable search =
                () -> {
                    int length = arr.length;
                    int blockSize = (int) Math.sqrt(length);
                    int step = blockSize;

                    int prev = 0;
                    while (arr[Math.min(step, length) - 1] < target) {
                        prev = step;
                        step += blockSize;
                        if (prev >= length) {
                            System.out.println("Target cannot be found!");
                            return;
                        }
                    }

                    while (arr[prev] < target) {
                        prev++;
                        if (prev == Math.min(step, length)) {
                            System.out.println("Target cannot be found!");
                            return;
                        }
                    }

                    if (arr[prev] == target) {
                        System.out.println("Target found at index " + prev + ".");
                    } else {
                        System.out.println("Target cannot be found!");
                    }
                };
        run.test(search, "Jump Search");

        return run.algorithmTakes;
    }
}
