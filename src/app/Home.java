package app;

import app.constants.Constants;
import app.helpers.AlgorithmHelpers;
import javals.searching.*;
import javals.sorting.*;
import app.ui.*;
import java.util.Arrays;
import java.util.Scanner;

/** Home */
public class Home {
    private final LinearSearch ls = new LinearSearch();
    private final BinarySearch bs = new BinarySearch();
    private final BubbleSort bsort = new BubbleSort();
    private final UserInterface ui = new UserInterface();
    private final Constants cs = new Constants();
    private final AlgorithmHelpers ahlp = new AlgorithmHelpers();
    private final Scanner sc = new Scanner(System.in);

    private final int[] arr = {1, 2, 4, 5, 6, 7, 8, 9, 10};
    private final int[] uarr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    public void start() {
        String response;

        do {
            ui.title();
            ui.menu(cs.getMenuOptions());
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    ui.menu(cs.getTestOptions());
                    int algorithmChoice = sc.nextInt();

                    if (algorithmChoice == 1) {
                        ui.menu(cs.getSearchingAlgorithmOptions());
                        int searchChoice = sc.nextInt();
                        ahlp.performSearching(searchChoice);
                    } else {
                        ui.menu(cs.getSortingAlgorithmOptions());
                        int sortingChoice = sc.nextInt();
                        ahlp.performSorting(choice);


                    }
                    break;

                case 2:
                    System.out.println("Compare Algorithm");
                    System.out.println("[1] Linear Search");
                    System.out.println("[2] Binary Search");
                    System.out.print("Pick the first algorithm: ");
                    int firstChoice = sc.nextInt();

                    System.out.println((firstChoice == 1) ? "Linear Search" : "Binary Search");

                    System.out.print("Pick the second algorithm: ");
                    int secondChoice = sc.nextInt();

                    System.out.println((secondChoice == 1) ? "Linear Search" : "Binary Search");

                    if (firstChoice == 1 && secondChoice == 2) {
                        System.out.println("Linear Search VS Binary Search");
                        System.out.print("Array: ");
                        System.out.println(Arrays.toString(arr));
                        System.out.println("Enter the data you want to find: ");
                        int target = sc.nextInt();
                        ls.linearSearch(arr, target);
                        bs.binarySearch(arr, target);
                    }
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }

            do {
                System.out.println("Do you want to try again [Y/N]");
                response = sc.next();
            } while (!response.equalsIgnoreCase("n") && !response.equalsIgnoreCase("y"));

        } while (!response.equalsIgnoreCase("n"));

        System.out.println("Thank you!");
        sc.close();
    }
}