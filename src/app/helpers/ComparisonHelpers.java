package app.helpers;

import app.base.Structure;
import app.constants.Constants;
import app.ui.UserInterface;
import java.util.Scanner;
import javals.searching.BinarySearch;
import javals.searching.JumpSearch;
import javals.searching.LinearSearch;

public class ComparisonHelpers {
  private final Structure struct;
  private final LinearSearch ls;
  private final BinarySearch bs;
  private final JumpSearch js;
  private final Scanner sc;
  private final UserInterface ui;
  private final Constants cs;
  private final InputHelpers input;

  public ComparisonHelpers() {
    input = new InputHelpers();
    struct = new Structure();
    ls = new LinearSearch();
    bs = new BinarySearch();
    sc = new Scanner(System.in);
    ui = new UserInterface();
    cs = new Constants();
    js = new JumpSearch();
  }

  public void performComparison() {
    int algorithmChoice = input.getInput("What type of algorithm you want to compare? ");
    switch (algorithmChoice) {
      case 1 -> searchingAlgorithmComparison();
      case 2 -> sortingAlgorithmComparison();
      default -> invalidChoice();
    }
  }

  private void searchingAlgorithmComparison() {
    int firstChoice;
    int secondChoice;

    System.out.println("[Searching Algorithm]");
    ui.menu(cs.getSearchingAlgorithmOptions());
    System.out.println("Compare the searching algorithm you want!");

    firstChoice = input.getInput("First algorithm: ");

    printSearchingAlgorithmChoice(firstChoice);

    secondChoice = input.getInput("Second algorithm: ");

    printSearchingAlgorithmChoice(secondChoice);

    comparisonOverview(firstChoice, secondChoice);
  }

  private void sortingAlgorithmComparison() {
    int firstChoice;
    int secondChoice;

    System.out.println("[Sorting Algorithm]");
    ui.menu(cs.getSortingAlgorithmOptions());
    System.out.println("Compare the searching algorithm you want!");
    System.out.println("First algorithm: ");
    firstChoice = sc.nextInt();
    System.out.println("Second algorithm: ");
    secondChoice = sc.nextInt();

    if (firstChoice == 1 || secondChoice == 1) {
      System.out.println("Bubble Sort");
    } else if (firstChoice == 2 || secondChoice == 2) {
      System.out.println("Selection Sort");
    } else {
      System.out.println("Insertion Sort");
    }
  }

  private void invalidChoice() {
    System.out.println("Invalid Choice!");
  }

    // error
    // this will be fix to be more accurate result.
    private void comparisonResult(long firstAlgorithmTime, long secondAlgorithmTime, String firstAlgorithmName, String secondAlgorithmName) {
        long thresholdMillis = 1;

        double firstAlgorithmMillis = (double) firstAlgorithmTime ;
        double secondAlgorithmMillis = (double) secondAlgorithmTime ;

        if (firstAlgorithmMillis < secondAlgorithmMillis - thresholdMillis) {
            System.out.println(firstAlgorithmName + " is faster than " + secondAlgorithmName + " by at least " + (secondAlgorithmMillis - firstAlgorithmMillis) + " nanoseconds.");
        } else if (secondAlgorithmMillis < firstAlgorithmMillis - thresholdMillis) {
            System.out.println(secondAlgorithmName + " is faster than " + firstAlgorithmName + " by at least " + (secondAlgorithmMillis - firstAlgorithmMillis) + " nanoseconds.");
        } else {
            if (firstAlgorithmTime < secondAlgorithmTime) {
                System.out.println(firstAlgorithmName + " is faster than " + secondAlgorithmName + " by " + (secondAlgorithmMillis - firstAlgorithmMillis) + " nanoseconds.");
            } else if (secondAlgorithmTime < firstAlgorithmTime) {
                System.out.println(secondAlgorithmName + " is faster than " + firstAlgorithmName + " by " + (firstAlgorithmMillis - secondAlgorithmMillis) + " nanoseconds.");
            } else {
                System.out.println(firstAlgorithmName + " and " + secondAlgorithmName + " have the same execution time.");
            }
        }
    }



    private void printSearchingAlgorithmChoice(int choice) {
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
  }

  private void printSortingAlgorithmChoice(int choice) {
    String algorithmName = "";
    if (choice == 1) {
      algorithmName = "Bubble Sort";
    } else if (choice == 2) {
      algorithmName = "Selection Sort";
    } else {
      algorithmName = "Insertion Sort";
    }
    System.out.println(algorithmName);
  }

  private void comparisonOverview(int firstChoice, int secondChoice) {
    int target = 0;
    double firstAlgorithm;
    double secondAlgorithm;
    String firstAlgorithmName = "";
    String secondAlgorithmName = "";

    firstAlgorithmName =
        switch (firstChoice) {
          case 1 -> "Linear Search";
          case 2 -> "Binary Search";
          case 3 -> "Jump Search";
          case 4 -> "Interpolation Search";
          default -> "Exponential Search";
        };

    secondAlgorithmName =
        switch (secondChoice) {
          case 1 -> "Linear Search";
          case 2 -> "Binary Search";
          case 3 -> "Jump Search";
          case 4 -> "Interpolation Search";
          default -> "Exponential Search";
        };

    System.out.println("Algorithm 1: " + firstAlgorithmName);
    System.out.println("Algorithm 2: " + secondAlgorithmName);
    System.out.print("Structure: ");
    struct.searchingStructure();

    target = input.getInput("Enter the target element: ");

    System.out.println("Algorithm 1: " + firstAlgorithmName);
    firstAlgorithm =
        switch (firstChoice) {
          case 1 -> ls.linearSearch(struct.sortedStruct, target);
          case 2 -> bs.binarySearch(struct.sortedStruct, target);
          case 3 -> js.jumpSearch(struct.sortedStruct, target);
          default -> throw new IllegalStateException("Unexpected value: " + firstChoice);
        };

    System.out.println("Algorithm 2: " + secondAlgorithmName);
    secondAlgorithm =
        switch (secondChoice) {
          case 1 -> ls.linearSearch(struct.sortedStruct, target);
          case 2 -> bs.binarySearch(struct.sortedStruct, target);
          case 3 -> js.jumpSearch(struct.sortedStruct, target);
          default -> throw new IllegalStateException("Unexpected value: " + secondChoice);
        };

    comparisonResult(firstChoice, secondChoice, firstAlgorithmName, secondAlgorithmName);
  }
}
