// Name: Aaron Brown
// Course: CSC 285
// Project: Lab #2 (Strategy Pattern)
// File Name: Main.java

public class Main {

    // main method in the driver class
    public static void main(String[] args) {
        Shipment shipment = new Shipment();

        // DEFAULT
        shipment.executeWriteToFile();

        // UPS
        shipment.setCarrier(new UPSFileWrite());
        shipment.executeWriteToFile();

        // FEDEX
        shipment.setCarrier(new FEDEXFileWrite());
        shipment.executeWriteToFile();

        // DHL
        shipment.setCarrier(new DHLFileWrite());
        shipment.executeWriteToFile();

        // BIGBOBS
        shipment.setCarrier(new BIGBOBSFileWrite());
        shipment.executeWriteToFile();

    }
}