package app.helpers;

import app.base.*;

import java.util.Arrays;
import java.util.Scanner;
import javals.searching.BinarySearch;
import javals.searching.LinearSearch;
import javals.sorting.BubbleSort;

/** AlgorithmHelpers */
public class AlgorithmHelpers {

    private final LinearSearch ls = new LinearSearch();
    private final BinarySearch bs = new BinarySearch();
    private final BubbleSort bsort = new BubbleSort();
    private final Scanner sc = new Scanner(System.in);
    private final Structure struct = new Structure();

    public void performSearching(int choice) {
        System.out.println((choice == 1) ? "Linear Search" : "BinarySearch");
        System.out.print("Structure: ");
        struct.searchingStructure();
        System.out.print("Enter the data you want to find inside of the structure: ");
        int target = sc.nextInt();

        if (choice == 1) {
            ls.linearSearch(struct.sortedStruct, target);
        } else {
            bs.binarySearch(struct.sortedStruct, target);
        }
    }

    public void performSorting(int choice) {
        System.out.println((choice == 1) ? "Bubble Sort" : "Selection Sort");
        System.out.print("Unsorted Array: ");
        struct.unsortedStructure();
        if (choice == 1) {
            System.out.print("Sorted Array: ");
            bsort.bubblesort(struct.unsortedStruct);
            struct.sortedStructure();
        } else {
            System.out.println("Sorted Array: ");
            bsort.bubblesort(struct.unsortedStruct);
            struct.sortedStructure();
        }
    }
}