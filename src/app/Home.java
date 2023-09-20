package app;

import app.constants.Constants;
import app.helpers.AlgorithmHelpers;
import app.helpers.ComparisonHelpers;
import javals.searching.*;
import app.ui.*;
import java.util.Scanner;

/** Home */
public class Home {
    private final LinearSearch ls = new LinearSearch();
    private final BinarySearch bs = new BinarySearch();
    private final UserInterface ui = new UserInterface();
    private final Constants cs = new Constants();
    private final AlgorithmHelpers helpers = new AlgorithmHelpers();
    private final ComparisonHelpers comparing = new ComparisonHelpers();
    private final Scanner sc = new Scanner(System.in);

    private final int[] arr = {1, 2, 4, 5, 6, 7, 8, 9, 10};

    public void start() {
        String response;

        do {
            ui.title();
            ui.menu(cs.getMenuOptions(), "Test or Compare? ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    ui.menu(cs.getTestOptions(), "Searching or Sorting? ");
                    int algorithmChoice = sc.nextInt();
                    if (algorithmChoice == 1) {
                        ui.menu(cs.getSearchingAlgorithmOptions(), "Pick a type of algorithm: ");
                        int searchChoice = sc.nextInt();
                        helpers.performSearching(searchChoice);
                    } else {
                        ui.menu(cs.getSortingAlgorithmOptions(), "Pick a type of algorithm: ");
                        int sortingChoice = sc.nextInt();
                        helpers.performSorting(sortingChoice);
                    }
                }
                case 2 -> {
                    ui.menu(cs.getComparisonOptions(), "What type of algorithm you want to compare? ");
                    comparing.performComparison();
                }
                default -> System.out.println("Invalid choice");
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