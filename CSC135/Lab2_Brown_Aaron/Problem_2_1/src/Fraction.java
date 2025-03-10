/* 
Name: Aaron Brown
Course: CSC 135
Project: Problem 2.1
File name: Fraction.java
 */
import java.util.Scanner; // imports scanner class


public class Fraction {
    
    // Converts the fraction to a decimal
    public static void main(String[] args) {
        Scanner getInteger = new Scanner(System.in);
        System.out.println("Input the numerator");
        float numerator = getInteger.nextInt();
        System.out.println("Input the denominator");
        float denominator = getInteger.nextInt();
        System.out.println("Your decimal is " + numerator / denominator);
    }
    
}
