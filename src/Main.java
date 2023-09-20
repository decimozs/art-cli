import app.Home;

/** Main */
public class Main {
    public static void main(String[] args) {
        try {
            Home run = new Home();
            run.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}