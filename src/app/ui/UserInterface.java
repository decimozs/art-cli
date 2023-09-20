package app.ui;

import java.util.List;

/** UserInterface */
public class UserInterface {

    public void title() {
        System.out.println("ART - [Algorithm Runtime Tester]");
    }

    public void pickMenuChoices(String instruction) {
        System.out.println(instruction);
    }

    public void pickAlgorithm() {
        System.out.print("Pick an algorithm you want to test: ");
    }

    public void menu(List<String> options, String instruction) {
        int size = options.size();
        for (int i = 0; i < size; i++) {
            System.out.println("[" + (i + 1) + "]" + options.get(i));
        }
        pickMenuChoices(instruction);
    }

}