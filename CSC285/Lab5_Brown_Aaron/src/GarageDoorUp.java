// Name: Aaron Brown
// Course: CSC 285
// Project: Lab #5 (Command Pattern)
// File Name: GarageDoorUp.java
public class GarageDoorUp implements Command {
    private final GarageDoor garageDoor;

    /**
     * Constructor that takes in and stores the garageDoor
     * @param gd
     */
    public GarageDoorUp(GarageDoor gd) {
        this.garageDoor = gd;
    }

    /**
     * Checks if the door is open; If closed, opens it.
     * Otherwise, tells the user it's already open.
     */
    @Override
    public void execute() {
        if (!garageDoor.isOpen()) {
            this.garageDoor.open();
        } else {
            System.out.println("Garage is already open");
        }
    }

    /**
     * Closes the garage door
     */
    @Override
    public void undo() {
        this.garageDoor.close();
    }
}
