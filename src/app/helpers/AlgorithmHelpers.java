package app.helpers;

import app.base.*;
import java.util.Scanner;
import javals.searching.BinarySearch;
import javals.searching.JumpSearch;
import javals.searching.LinearSearch;
import javals.sorting.BubbleSort;

/** AlgorithmHelpers */
public class AlgorithmHelpers {

  private final LinearSearch ls;
  private final BinarySearch bs;
  private final BubbleSort bsort;
  private final Scanner sc;
  private final Structure struct;
  private final JumpSearch js;
  private final ComparisonHelpers chlp;

  public AlgorithmHelpers() {
    chlp = new ComparisonHelpers();
    js = new JumpSearch();
    ls = new LinearSearch();
    bs = new BinarySearch();
    bsort = new BubbleSort();
    sc = new Scanner(System.in);
    struct = new Structure();
  
  
  
  
  }

  public void performSearching(int choice) {
    String algorithmName = "";
    algorithmName =
        switch (choice) {
          case 1 -> "Linear Search";
          case 2 -> "Binary Search";
          case 3 -> "Jump Search";
          case 4 -> "Interpolation Search";
          default -> "Exponential Search";
        };
    System.out.println(algorithmName);
    System.out.print("Structure: ");
    struct.searchingStructure();
    System.out.print("Enter the target element: ");

    int target = sc.nextInt();
 
     switch (choice) {
          case 1 -> ls.linearSearch(struct.sortedStruct, target);
          case 2 -> bs.binarySearch(struct.sortedStruct, target);
          case 3 -> js.jumpSearch(struct.sortedStruct, target);
          default -> throw new IllegalStateException("Unexpected value: " + firstChoice); 
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
