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

    public String getInitialCommand() {
        return initialCommand;
    }

    public void setInitialCommand(String initialCommand) {
        this.initialCommand = initialCommand;
    }

    public List<String> getUserInputs() {
        return userInputs;
    }

    public void setUserInputs(List<String> userInputs) {
        this.userInputs = userInputs;
    }
}
