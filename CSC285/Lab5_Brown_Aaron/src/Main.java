// Name: Aaron Brown
// Course: CSC 285
// Project: Lab #5 (Command Pattern)
// File Name: Main.java
public class Main {
    // main & driver method
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl(2);
        GarageDoor garageDoor = new GarageDoor("Main");

        remote.setButton(0, new GarageDoorUp(garageDoor));
        remote.setButton(1, new GarageDoorDown(garageDoor));

        remote.pressButton(0);
        remote.pressButton(1);
        remote.pressButton(2);
        remote.undo();
        remote.undo();
        remote.undo();
    }
}