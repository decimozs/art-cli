package app;

import app.constants.Constants;
import app.helpers.AlgorithmHelpers;
import app.helpers.ComparisonHelpers;
import app.helpers.InputHelpers;
import app.ui.*;
import java.util.Scanner;

/** Home */
public class Home {
    private final UserInterface ui;
    private final Constants cs;
    private final AlgorithmHelpers helpers;
    private final ComparisonHelpers comparing;
    private final Scanner sc;
    private final InputHelpers input;

    public Home () {
        ui = new UserInterface();
        cs = new Constants();
        helpers = new AlgorithmHelpers();
        comparing = new ComparisonHelpers();
        sc = new Scanner(System.in);
        input = new InputHelpers();
    }

    public void start() {
        String response;

        do {
            ui.title();
            ui.menu(cs.getMenuOptions());
            int choice = input.getInput("Test or Compare? ");

            switch (choice) {
                case 1 -> {
                    ui.menu(cs.getTestOptions());
                    int algorithmChoice = input.getInput("Searching or Sorting? ");
                    if (algorithmChoice == 1) {
                        ui.menu(cs.getSearchingAlgorithmOptions());
                        int searchChoice = input.getInput("Pick a type of algorithm: ");
                        helpers.performSearching(searchChoice);
                    } else {
                        ui.menu(cs.getSortingAlgorithmOptions());
                        int sortingChoice = input.getInput("Pick a type of algorithm: ");
                        helpers.performSorting(sortingChoice);
                    }
                }
                case 2 -> {
                    ui.menu(cs.getComparisonOptions());
                    comparing.performComparison();
                }
                default -> System.out.println("Invalid choice");
            }

            do {
                System.out.println();
                response = input.getStringInput("Do you want to try again [Y/N]");
            } while (!response.equalsIgnoreCase("n") && !response.equalsIgnoreCase("y"));

        } while (!response.equalsIgnoreCase("n"));

        System.out.println("Thank you!");
        sc.close();
    }
}