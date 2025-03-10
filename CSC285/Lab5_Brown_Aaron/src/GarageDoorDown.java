// Name: Aaron Brown
// Course: CSC 285
// Project: Lab #5 (Command Pattern)
// File Name: GarageDoorDown.java
public class GarageDoorDown implements Command {
    private final GarageDoor garageDoor;

    /**
     * Constructor that takes in and stores the garageDoor
     * @param gd
     */
    public GarageDoorDown(GarageDoor gd) {
        this.garageDoor = gd;
    }

    /**
     * Checks if the door is closed; If open, closes it.
     * Otherwise, tells the user it's already closed.
     */
    @Override
    public void execute() {
        if (garageDoor.isOpen()) {
            this.garageDoor.close();
        } else {
            System.out.println("Garage is already closed");
        }
    }

    /**
     * Opens the garage door
     */
    @Override
    public void undo() {
        this.garageDoor.open();
    }
}
