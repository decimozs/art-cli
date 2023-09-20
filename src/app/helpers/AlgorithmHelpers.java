package app.helpers;

import app.base.*;
import java.util.Scanner;
import javals.searching.BinarySearch;
import javals.searching.LinearSearch;
import javals.sorting.BubbleSort;

/** AlgorithmHelpers */
public class AlgorithmHelpers {

  private final LinearSearch ls;
  private final BinarySearch bs;
  private final BubbleSort bsort;
  private final Scanner sc;
  private final Structure struct;

  public AlgorithmHelpers() {
    ls = new LinearSearch();
    bs = new BinarySearch();
    bsort = new BubbleSort();
    sc = new Scanner(System.in);
    struct = new Structure();
  }

  public void performSearching(int choice) {
    System.out.println((choice == 1) ? "Linear Search" : "BinarySearch");
    System.out.print("Structure: ");
    struct.searchingStructure();
    System.out.print("Enter the target element: ");
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
      bsort.bubblesort(struct.unsortedStruct);
      System.out.print("Sorted Array: ");
      struct.sortedStructure();
    } else {
      bsort.bubblesort(struct.unsortedStruct);
      System.out.println("Sorted Array: ");
      struct.sortedStructure();
    }
  }
}
