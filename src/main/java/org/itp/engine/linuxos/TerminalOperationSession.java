package org.itp.engine.linuxos;

import java.util.List;

public class TerminalOperationSession {

    private String initialCommand;
    private List<String> userInputs;

    public TerminalOperationSession() {
    }

    public TerminalOperationSession(String initialCommand, List<String> userInputs) {
        this.initialCommand = initialCommand;
        this.userInputs = userInputs;
    }

    public TerminalOperationSession setInitialCommand(String initialCommand) {
        this.initialCommand = initialCommand;
        return this;
    }

    public TerminalOperationSession addUserInput(String input) {
        this.userInputs.add(input);
        return this;
    }

    public String getInitialCommand() {
        return initialCommand;
    }

    public List<String> getUserInputs() {
        return userInputs;
    }

}
