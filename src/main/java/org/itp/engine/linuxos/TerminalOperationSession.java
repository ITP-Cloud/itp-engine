package org.itp.engine.linuxos;

import java.util.ArrayList;
import java.util.List;

public class TerminalOperationSession {

    private String initialCommand;
    private List<String> userInputs;

    public TerminalOperationSession() {
        this.initialCommand = "";
        this.userInputs = new ArrayList<String>();
    }

    public TerminalOperationSession(String initialCommand) {
        this.initialCommand = initialCommand;
        this.userInputs = new ArrayList<String>();
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

