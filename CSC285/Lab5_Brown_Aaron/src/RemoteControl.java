// Name: Aaron Brown
// Course: CSC 285
// Project: Lab #5 (Command Pattern)
// File Name: RemoteControl.java
import java.util.ArrayList;

public class RemoteControl {
    Command[] buttons;
    ArrayList<Command> history;

    /**
     * Constructor that sets how many buttons the remote will hold.
     * Creates a history log to allow undoes.
     *
     * @param buttonCount
     */
    public RemoteControl(int buttonCount) {
        buttons = new Command[buttonCount];
        history = new ArrayList<>();
    }

    /**
     * Configures the button of given index to perform provided command when pressed
     *
     * @param index
     * @param cmd
     */
    public void setButton(int index, Command cmd) {
        if (index >= 0 && index < buttons.length) {
            buttons[index] = cmd;
        } else {
            System.out.println("There is not a " + index + " button");
        }
    }

    /**
     * Executes the command of the button pressed determined by the index given.
     * Adds the command to the history to allow undoes.
     * Has error prevention with explanation.
     *
     * @param index
     */
    public void pressButton(int index) {
        if (!(index >= 0 && index < buttons.length)) {
            System.out.println("There is not a " + index + " button");
        }
        else if (buttons[index] == null) {
            System.out.println("There is not a command set for " + index + " button");
        } else {
            buttons[index].execute();
            history.add(buttons[index]);
        }
    }

    /**
     * Executes the undo method of the last command.
     * Has error handling with explanation.
     */
    public void undo(){
        if (!history.isEmpty()){
            Command lastCommand = history.getLast();
            lastCommand.undo();
            history.removeLast();
        } else {
            System.out.println("There are no more commands to undo");
        }
    }
}
