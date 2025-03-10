// Name: Aaron Brown
// Course: CSC 285
// Project: Lab #1 (Singleton)
// File Name: Main.java

public class Main {

    // Main driver method
    public static void main(String[] args) {
        AccountNumberGenerator instance = AccountNumberGenerator.getInstance(); // Creates singleton instance of AccountNumberGenerator

        System.out.println(instance.getNextNumber()); // Adds +1 & Gets AccountNumber
        System.out.println(instance.getNextNumber());
    }
}
