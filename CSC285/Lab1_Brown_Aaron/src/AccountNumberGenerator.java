// Name: Aaron Brown
// Course: CSC 285
// Project: Lab #1 (Singleton)
// File Name: AccountNumberGenerator.java

public class AccountNumberGenerator{

    long accountNumber;
    private static AccountNumberGenerator instance;

    // instance = new Increment(); // Creating the object here is called the Early Instantiation

    // Private constructor to prevent an object being created outside the class
    private AccountNumberGenerator() {}

    /**
     * Ensures that there is only one object of AccountNumberGenerator
     *
     * @return AccountNumberGenerator Object
     */
    public synchronized static AccountNumberGenerator getInstance() {
        // Creating the object in the getInstance method is called the Lazy Instantiation
        if (instance == null) {
            instance = new AccountNumberGenerator();
        }
        return instance;
    }

    /**
     * Increments the accountNumber
     *
     * @return String - formatted accountNumber
     */
    public synchronized String getNextNumber() {
        accountNumber++;
        return String.format("%06d", accountNumber);
    }
}
