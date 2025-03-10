// Name: Aaron Brown
// Course: CSC 285
// Project: Lab #5 (Command Pattern)
// File Name: GarageDoor.java
public class GarageDoor {
    private boolean open;
    private final String name;

    /**
     * Constructor that defaults the garage door to be false and stores the name of it.
     * @param name
     */
    public GarageDoor(String name) {
        this.name = name + " Garage Door";
        this.open = false;
    }

    /**
     * Sets the open var to true and prints statement
     */
    public void open() {
        this.open = true;
        System.out.println(this.name + " is open");
    }

    /**
     * Sets the open var to false and prints statement
     */
    public void close() {
        this.open = false;
        System.out.println(this.name + " is closed");
    }

    /**
     * returns whether the garage door is open or not.
     * @return open
     */
    public boolean isOpen() {
        return this.open;
    }
}
