/* 
Name: Aaron Brown
Course: CSC 135
Project: Problem 2.2
File name: Hundreds.java
 */
import java.util.Scanner; // imports scanner class


public class Hundreds {
    
    // adds all of the integers that are in the hundreds place
    public static void main(String[] args) {
        //Hundreds.stringMethod();
        //Hundreds.charMethod();
        Hundreds.intMethod(); // I get an error when the input integer is too big
    }
    public static void intMethod() {
        Scanner getInteger = new Scanner(System.in);
        System.out.println("Input your first number");
        int firstNum = getInteger.nextInt();
        System.out.println("Input your second number");
        int secondNum = getInteger.nextInt();
        int firstHundreds = 0; int secondHundreds = 0; // initialize values
        if (firstNum >= 100) {
            firstHundreds = (firstNum / 100)%10;
        } 
        if (secondNum >= 100) {
            secondHundreds = (secondNum / 100)%10;
        }
        System.out.println(firstHundreds + secondHundreds);
    }
    
    public static void stringMethod() {
        Scanner getInteger = new Scanner(System.in);
        System.out.println("Input your first number");
        String firstNum = getInteger.nextLine();
        System.out.println("Input your second number");
        String secondNum = getInteger.nextLine();
        int firstHundreds = 0; int secondHundreds = 0; // initialize values
        int firstLength = firstNum.length(); int secondLength = secondNum.length();
        // Uses parseInt & substring
        if (firstLength >= 3) { // checks if the string contains a hundredth index
            firstHundreds = Integer.parseInt(firstNum.substring(firstLength-3,firstLength-2)); // overwrites the value to the hundredth digit
        }
        if (secondLength >= 3) { // checks if the string contains a hundredth index
            secondHundreds = Integer.parseInt(secondNum.substring(secondLength-3,secondLength-2)); // overwrites the value to the hundredth digit
        }
        System.out.println(firstHundreds + secondHundreds);
    }
    public static void charMethod() {
        Scanner getInteger = new Scanner(System.in);
        System.out.println("Input your first number");
        String firstNum = getInteger.nextLine();
        System.out.println("Input your second number");
        String secondNum = getInteger.nextLine();
        int firstHundreds = 0; int secondHundreds = 0; // initialize values
        int firstLength = firstNum.length(); int secondLength = secondNum.length();
        // Uses charAt & getNumericValue
        if (firstNum.length() >= 3) { // checks if the string contains a hundredth index
            firstHundreds = firstNum.charAt(firstNum.length()-3); // overwrites the value to the hundredth digit
            firstHundreds = Character.getNumericValue(firstHundreds);
        }
        if (secondNum.length() >= 3) { // checks if the string contains a hundredth index
            secondHundreds = secondNum.charAt(secondNum.length()-3); // overwrites the value to the hundredth digit
            secondHundreds = Character.getNumericValue(secondHundreds);
        }
        System.out.println(firstHundreds + secondHundreds);
        
    }
}
