package app.helpers;

import java.util.Scanner;

public class InputHelpers {
    public final Scanner sc;
    public InputHelpers(){
        sc = new Scanner(System.in);
    }

    public int getInput(String message){
        System.out.println(message);
        return sc.nextInt();
    }

    public String getStringInput(String message){
        System.out.println(message);
        return sc.next();
    }
}
