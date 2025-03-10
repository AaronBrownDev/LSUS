/*
Name: Aaron Brown
Course: CSC 135
Project: In-class Problem 2.1
File: MyExampleErrors.java
*/
import java.util.Scanner; // imports scanner class

public class MyExampleErrors {

    // divides two integer inputs1
    public static void main(String[] args) {
        Scanner getInteger = new Scanner(System.in);
        System.out.println("Input your first value:");
        int a = getInteger.nextInt();
        System.out.println("Input your second value:");
        int b = getInteger.nextInt();
        float result = (float)a/b;
        System.out.println(result);
        // TODO code application logic here
    }
    
}
