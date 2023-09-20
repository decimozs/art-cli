package javals.sorting;

import app.utils.RuntimeTester;
/** bubblesort */
public class BubbleSort {

    public int count = 0;
    RuntimeTester run = new RuntimeTester();

    public void bubblesort (int[] arr) {
        Runnable sort =
                () -> {
                    int length = arr.length;
                    boolean swapped;

                    for (int i = 0; i < length - 1; i++) {
                        swapped = false;
                        for (int j = 0; j < length - i - 1; j++) {
                            if (arr[j] > arr[j + 1]) {
                                int temp = arr[j];
                                arr[j] = arr[j + 1];
                                arr[j + 1] = temp;
                                swapped = true;
                                count++;
                            }
                        }
                        if (!swapped) {
                            break;
                        }
                    }

                    System.out.println("Swapping counts: " + count);
                };
        run.test(sort);
    }
}