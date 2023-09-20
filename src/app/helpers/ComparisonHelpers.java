package app.helpers;

import app.base.Structure;
import app.constants.Constants;
import app.ui.UserInterface;
import javals.searching.BinarySearch;
import javals.searching.LinearSearch;

import java.util.List;
import java.util.Scanner;

public class ComparisonHelpers {
    private final Structure struct;
    private final LinearSearch ls;
    private final BinarySearch bs;
    private final Scanner sc;
    private final UserInterface ui;
    private final Constants cs;
    private final InputHelpers input;

    public ComparisonHelpers(){
        input = new InputHelpers();
        struct = new Structure();
        ls = new LinearSearch();
        bs = new BinarySearch();
        sc = new Scanner(System.in);
        ui = new UserInterface();
        cs = new Constants();
    }

    public void performComparison() {
        int algorithmChoice = input.getInput("What type of algorithm you want to compare? ");
        switch (algorithmChoice) {
            case 1 -> searchingAlgorithmComparison();
            case 2 -> sortingAlgorithmComparison();
            default -> invalidChoice();
        }
    }

    private void searchingAlgorithmComparison(){
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

    private void sortingAlgorithmComparison(){
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
        } else if (firstChoice == 2 || secondChoice == 2){
            System.out.println("Selection Sort");
        } else {
            System.out.println("Insertion Sort");
        }
    }

    private void invalidChoice(){
        System.out.println("Invalid Choice!");
    }

    private void comparisonResult(long firstAlgorithm, long secondAlgorithm){
        if (firstAlgorithm > secondAlgorithm) {
            System.out.println("Algorithm 2 has a faster way to found the target element.");
        } else {
            System.out.println("Algorithm 1 has a faster way to found the target element.");
        }
    }

    private void printSearchingAlgorithmChoice(int choice){
        String algorithmName = "";
        if (choice == 1) {
            algorithmName = "Linear Search";
        } else if (choice == 2) {
            algorithmName = "Binary Search";
        } else {
            algorithmName = "Jump Search";
        }
        System.out.println("Algorithm: " + algorithmName);
    }

    private void printSortingAlgorithmChoice(int choice){
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

    private void comparisonOverview (int firstChoice, int secondChoice) {
        int target;
        long firstAlgorithm;
        long secondAlgorithm;
        
        if (firstChoice == 1 && secondChoice == 2) {
            System.out.println("Algorithm 1: Linear Search");
            System.out.println("Algorithm 2: Binary Search");
            System.out.print("Structure: ");
            struct.searchingStructure();
            target = input.getInput("Enter the target element: ");
            System.out.println("Algorithm 1: Linear Search");
            firstAlgorithm = ls.linearSearch(struct.sortedStruct, target);
            System.out.println("Algorithm 2: Binary Search");
            secondAlgorithm = bs.binarySearch(struct.sortedStruct, target);

            comparisonResult(firstAlgorithm, secondAlgorithm);
        } else {
            System.out.println("Algorithm 1: Binary Search");
            System.out.println("Algorithm 2: Linear Search");
            System.out.print("Structure: ");
            struct.searchingStructure();
            System.out.println("Enter the target element: ");
            target = input.getInput("Enter the target element: ");
            System.out.println("Algorithm 1: Binary Search");
            firstAlgorithm = bs.binarySearch(struct.sortedStruct, target);
            System.out.println("Algorithm 2: Linear Search");
            secondAlgorithm = ls.linearSearch(struct.sortedStruct, target);

            comparisonResult(firstAlgorithm, secondAlgorithm);
        }
    }
}
