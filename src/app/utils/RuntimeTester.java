package app.utils;

public class RuntimeTester {
    public void test(Runnable algorithm, String algorithmName) {
        long startTime = System.nanoTime();
        algorithm.run();
        long elapsedTime = System.nanoTime();
        long algorithmTakes = elapsedTime - startTime;
        System.out.println("The " + algorithmName + " takes " + algorithmTakes + " nanoseconds.");
    }
}
