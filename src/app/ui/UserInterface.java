package app.ui;

import java.util.List;

/** UserInterface */
public class UserInterface {

    public void title() {
        System.out.println("ART - [Algorithm Runtime Tester]");
    }

    public void pickMenuChoices() {
        System.out.println("Test or Compare? ");
    }

    public void pickAlgorithm() {
        System.out.print("Pick an algorithm you want to test: ");
    }

    public void menu(List<String> options) {
        int size = options.size();
        for (int i = 0; i < size; i++) {
            System.out.println("[" + (i + 1) + "]" + options.get(i));
        }
        pickMenuChoices();
    }

    public void searchingAlgorithm(List<String> options) {
        int size = options.size();
        for (int i = 0; i < size; i++) {
            System.out.println("[" + (i + 1) + "]" + options.get(i));
        }
        pickAlgorithm();
    }

    public void sortingAlgorithm(List<String> options) {
        int size = options.size();
        for (int i = 0; i < size; i++) {
            System.out.println("[" + (i + 1) + "]" + options.get(i));
        }
        pickAlgorithm();
    }
}