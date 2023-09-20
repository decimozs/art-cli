package app.constants;

import java.util.ArrayList;
import java.util.List;

/** Constants */
public class Constants {

    public List<String> getMenuOptions() {
        List<String> options = new ArrayList<>();
        options.add("Test Algorithm");
        options.add("Compare Algorithms");
        options.add("Exit");
        return options;
    }

    public List<String> getTestOptions() {
        List<String> options = new ArrayList<>();
        options.add("Searching Algorithm");
        options.add("Sorting Algorithm");
        options.add("Exit");
        return options;
    }

    public List<String> getSearchingAlgorithmOptions() {
        List<String> options = new ArrayList<>();
        options.add("Linear Search");
        options.add("Binary Search");
        options.add("Exit");
        return options;
    }

    public List<String> getSortingAlgorithmOptions() {
        List<String> options = new ArrayList<>();
        options.add("Bubble Sort");
        options.add("Selection Sort");
        options.add("Insertion Sort");
        return options;
    }
}