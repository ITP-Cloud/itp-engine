package org.itp.engine.useraccount;

import org.itp.engine.linuxos.LinuxTerminal;
import org.itp.engine.linuxos.TerminalOperationSession;
import org.itp.engine.linuxos.TerminalOperationSessionFactory;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

    public boolean createUser(UserAccount user){

        TerminalOperationSession session = TerminalOperationSessionFactory
                .getSessionWith("adduser "+ user.getLinuxUsername());
        session
                .addUserInput(user.getLinuxPassword())
                .addUserInput(user.getLinuxPassword())
                .addUserInput("")
                .addUserInput("")
                .addUserInput("")
                .addUserInput("")
                .addUserInput("")
                .addUserInput("Y");

        LinuxTerminal terminal = new LinuxTerminal();
        terminal.setSession(session);
        String output = terminal.executeSession();

        return output.contains("Adding user");
    }

    public boolean deleteUser(UserAccount user) {

        TerminalOperationSession session = TerminalOperationSessionFactory
                .getSessionWith("bash");
        session
                .addUserInput("groupdel " + user.getFtpUsername() + "_n_www-data")
                .addUserInput("userdel -r -f " + user.getLinuxUsername())
                .addUserInput("systemctl restart vsftpd")
                .addUserInput("systemctl reload apache2");

        LinuxTerminal terminal = new LinuxTerminal();
        terminal.setSession(session);
        terminal.executeSession();

        return true;
    }
}
