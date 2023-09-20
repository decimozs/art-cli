import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[100];
        System.out.println(Arrays.toString(arr));
        int length = arr.length;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));

        Random rand = new Random();
        for (int i = length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
