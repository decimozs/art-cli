package app.utils;

public class RuntimeTester {
    public void test(Runnable algorithm) {
        long startTime = System.nanoTime();
        algorithm.run();
        long elapsedTime = System.nanoTime();
        long algorithmTakes = elapsedTime - startTime;
        System.out.println("The algorithm takes " + algorithmTakes + " nanoseconds.");
    }
}
