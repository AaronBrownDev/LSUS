// Name: Aaron Brown
// Course: CSC 285
// Project: Lab #2 (Strategy Pattern)
// File Name: FEDEXBehavior.java

public class FEDEXFileWrite implements IWriteCarrierFile {

    // FEDEX unique writeToFile method that prints its corresponding statement
    public void writeToFile() {
        System.out.println("Write a file properly formatted for FEDEX");
    }

}
