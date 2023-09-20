package app.helpers;

import app.base.Structure;
import app.constants.Constants;
import app.ui.UserInterface;
import app.utils.RuntimeTester;
import javals.searching.BinarySearch;
import javals.searching.LinearSearch;

import java.util.Scanner;

public class ComparisonHelpers {
    private final RuntimeTester run = new RuntimeTester();
    private final Structure struct = new Structure();
    private final LinearSearch ls = new LinearSearch();
    private final BinarySearch bs = new BinarySearch();
    private final Scanner sc = new Scanner(System.in);
    private final UserInterface ui = new UserInterface();
    private final Constants cs = new Constants();
    public void performComparison() {
        int firstChoice;
        int secondChoice;
        int algorithmChoice = sc.nextInt();

        switch (algorithmChoice) {
            case 1 -> {
                System.out.println("[Searching Algorithm]");
                ui.menu(cs.getSearchingAlgorithmOptions(), "Compare the searching algorithm you want!");
                System.out.println("First algorithm: ");
                firstChoice = sc.nextInt();

                if (firstChoice == 1) {
                    System.out.println("Algorithm 1: Linear Search");
                } else  {
                    System.out.println("Algorithm 1: Binary Search");
                }

                System.out.println("Second algorithm: ");
                secondChoice = sc.nextInt();

                if (secondChoice == 1) {
                    System.out.println("Algorithm 2: Linear Search");
                } else  {
                    System.out.println("Algorithm 2: Binary Search");
                }

                if (firstChoice == 1 && secondChoice == 2) {
                    System.out.println("Algorithm 1: Linear Search");
                    System.out.println("Algorithm 2: Binary Search");
                    System.out.print("Structure: ");
                    struct.searchingStructure();
                    System.out.println("Enter the target element: ");
                    int target = sc.nextInt();
                    System.out.println("Algorithm 1: Linear Search");
                    long algo1 = ls.linearSearch(struct.sortedStruct, target);
                    System.out.println("Algorithm 2: Binary Search");
                    long algo2 = bs.binarySearch(struct.sortedStruct, target);

                    if (algo1 > algo2) {
                        System.out.println("Algorithm 2 has a faster way to found the target element.");
                    } else {
                        System.out.println("Algorithm 1 has a faster way to found the target element.");
                    }

                } else {
                    System.out.println("Algorithm 1: Binary Search");
                    System.out.println("Algorithm 2: Linear Search");
                    System.out.print("Structure: ");
                    struct.searchingStructure();
                    System.out.println("Enter the target element: ");
                    int target = sc.nextInt();
                    System.out.println("Algorithm 1: Binary Search");
                    long algo1 = bs.binarySearch(struct.sortedStruct, target);
                    System.out.println("Algorithm 2: Linear Search");
                    long algo2 = ls.linearSearch(struct.sortedStruct, target);

                    if (algo1 > algo2) {
                        System.out.println("Algorithm 2 has a faster way to found the target element.");
                    } else {
                        System.out.println("Algorithm 1 has a faster way to found the target element.");
                    }
                }
            }

            case 2 -> {
                System.out.println("[Sorting Algorithm]");
                ui.menu(cs.getSortingAlgorithmOptions(), "Compare the sorting algorithm you want!");
                System.out.println("First algorithm: ");
                firstChoice = sc.nextInt();
                System.out.println("Second algorithm: ");
                secondChoice = sc.nextInt();

                if (firstChoice == 1 || secondChoice == 1) {
                    System.out.println("Bubble Sort");
                } else if (firstChoice == 2 || secondChoice == 2){
                    System.out.println("Selection Sort");
                } else {
                    System.out.println("Insertion Sort");
                }
            }
            default -> System.out.println("Invalid Choice!");
        }
    }
}
