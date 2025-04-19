package org.knit.solutions.Task13;

public class RemoteControl {
    private Command command;
    private final java.util.Stack<Command> history = new java.util.Stack<>();

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
        history.push(command);
    }

    public void undoLastCommand() {
        if (!history.isEmpty()) {
            Command lastCommand = history.pop();
            lastCommand.undo();
        }
    }
}
