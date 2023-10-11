package org.itp.engine.database;

import org.itp.engine.linuxos.LinuxTerminal;
import org.itp.engine.linuxos.TerminalOperationSession;
import org.itp.engine.linuxos.TerminalOperationSessionFactory;
import org.itp.engine.useraccount.UserAccount;
import org.springframework.stereotype.Service;

@Service
public class DatabaseServerService {

    public boolean createDbAccount(UserAccount user) {
        TerminalOperationSession session = TerminalOperationSessionFactory
                .getSessionWith("mysql");

        session
                .addUserInput("CREATE USER '" + user.getDbUsername() + "'@'localhost' IDENTIFIED WITH caching_sha2_password BY '" + user.getDbPassword() + "'; ")
                .addUserInput("GRANT ALL PRIVILEGES ON `" + user.getDbUsername() + "\\_%`.* TO '" + user.getDbUsername() + "'@'localhost'; ")
                .addUserInput("exit")
                .addUserInput("");

        LinuxTerminal terminal = new LinuxTerminal();
        terminal.setSession(session);
        terminal.executeSession();

        return true;
    }

    public boolean updateDbAccount(UserAccount user) {
        TerminalOperationSession session = TerminalOperationSessionFactory
                .getSessionWith("mysql");

        session
                .addUserInput("ALTER USER '" + user.getDbUsername() + "'@'localhost' IDENTIFIED WITH caching_sha2_password BY '" + user.getDbUsername() + "';")
                .addUserInput("exit;");

        LinuxTerminal terminal = new LinuxTerminal();
        terminal.setSession(session);
        terminal.executeSession();

        return true;
    }

    public boolean deleteDbAccount(UserAccount user) {
        TerminalOperationSession session = TerminalOperationSessionFactory
                .getSessionWith("mysql");

        session
//  TODO: Find a query that works:
//  .addUserInput("REVOKE ALL PRIVILEGES FROM ON `"+user.getDbUsername()+ "\\_%`.* FROM '"+user.getDbUsername()+"'@'localhost';")
                .addUserInput("DROP USER '" + user.getDbUsername() + "'@'localhost';")
                .addUserInput("exit;");

        LinuxTerminal terminal = new LinuxTerminal();
        terminal.setSession(session);
        System.out.println(terminal.executeSession());

        return true;
    }

    public boolean createDB(Database database) {
        TerminalOperationSession session = TerminalOperationSessionFactory
                .getSessionWith("mysql");

        session
                .addUserInput("CREATE DATABASE "+database.getDatabaseName()+";")
                .addUserInput("exit;")
                .addUserInput("");

        LinuxTerminal terminal = new LinuxTerminal();
        terminal.setSession(session);
        terminal.executeSession();

        return true;
    }

    public boolean dropDB(Database database) {
        TerminalOperationSession session = TerminalOperationSessionFactory
                .getSessionWith("mysql");

        session
                .addUserInput("DROP DATABASE " + database.getDatabaseName() + ";")
                .addUserInput("exit;");

        LinuxTerminal terminal = new LinuxTerminal();
        terminal.setSession(session);
        terminal.executeSession();

        return true;
    }

}
