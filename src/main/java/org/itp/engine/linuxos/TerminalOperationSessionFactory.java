package org.itp.engine.linuxos;

public class TerminalOperationSessionFactory {
    public static TerminalOperationSession getSessionWith(String initialCommand){
        return new TerminalOperationSession().setInitialCommand(initialCommand);
    }
}

