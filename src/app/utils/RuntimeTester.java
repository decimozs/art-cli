package app.utils;

public class RuntimeTester {
    public double algorithmTakes;
    public void test(Runnable algorithm, String algorithmName) {
        long startTime = System.nanoTime();
        algorithm.run();
        long elapsedTime = System.nanoTime();
        algorithmTakes = elapsedTime - startTime;
        System.out.println("The " + algorithmName + " takes " + algorithmTakes + " nanoseconds.");
    }
}
