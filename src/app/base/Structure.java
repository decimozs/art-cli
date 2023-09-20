package app.base;

import java.util.Arrays;
import java.util.Random;

/** Structure */
public class Structure {
    public int[] sortedStruct = new int[100];
    public int[] unsortedStruct = new int[100];

    public void searchingStructure() {
        int length = sortedStruct.length;
        for (int i = 0; i < length; i++) {
            sortedStruct[i] = i + 1;
        }
        System.out.println(
                Arrays.toString(sortedStruct)
        );
    }

    public void sortedStructure() {
        int length = unsortedStruct.length;

        for (int i = 0; i < length; i++) {
            unsortedStruct[i] = i + 1;
        }

        System.out.println(Arrays.toString(unsortedStruct));
    }

    public void unsortedStructure() {
        Random rand = new Random();
        int length = unsortedStruct.length;

        for (int i = 0; i < length; i++) {
            unsortedStruct[i] = i + 1;
        }

        for (int i = length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = unsortedStruct[i];
            unsortedStruct[i] = unsortedStruct[j];
            unsortedStruct[j] = temp;
        }

        System.out.println(
                Arrays.toString(unsortedStruct)
        );
    }
}