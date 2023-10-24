package org.itp.engine.osutils;

public class TerminalOperationSessionFactory {
    public static TerminalOperationSession getSessionWith(String initialCommand){
        return new TerminalOperationSession().setInitialCommand(initialCommand);
    }
}

