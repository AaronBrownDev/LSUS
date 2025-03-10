// Name: Aaron Brown
// Course: CSC 285
// Project: Lab #2 (Strategy Pattern)
// File Name: Shipment.java

public class Shipment {

    private IWriteCarrierFile carrier;

    /**
     * empty public constructor
     */
    public Shipment() {}

    /**
     * constructor that sets carrier
     *
     * @param carrier
     */
    public Shipment(IWriteCarrierFile carrier) {
        this.carrier = carrier;
    }

    /**
     * method that sets carrier
     *
     * @param carrier
     */
    public void setCarrier(IWriteCarrierFile carrier) {
        this.carrier = carrier;
    }

    /**
     * executes the set carrier writeToFile method
     * or defaults to warning one isn't established
     */
    public void executeWriteToFile() {
        if (carrier != null) {
            carrier.writeToFile();
        } else {
            System.out.println("No carrier behavior is set");
        }

    }

}
