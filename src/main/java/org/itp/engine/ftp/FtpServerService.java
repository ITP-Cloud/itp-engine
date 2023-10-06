package org.itp.engine.ftp;

import org.itp.engine.linuxos.LinuxTerminal;
import org.itp.engine.linuxos.TerminalOperationSession;
import org.itp.engine.linuxos.TerminalOperationSessionFactory;
import org.itp.engine.useraccount.UserAccount;
import org.springframework.stereotype.Service;

@Service
public class FtpServerService {

    public boolean createFtpAccount(UserAccount user){
        TerminalOperationSession session = TerminalOperationSessionFactory
                .getSessionWith("systemctl restart vsftpd");

        session
                .addUserInput("mkdir /home/"+user.getLinuxUsername()+"/ftp")
                .addUserInput("chown nobody:nogroup /home/"+user.getLinuxUsername()+"/ftp")
                .addUserInput("chmod a-w /home/"+user.getLinuxUsername()+"/ftp")
                .addUserInput("mkdir /home/"+user.getLinuxUsername()+"/ftp/websites")
                .addUserInput("chown "+user.getLinuxUsername()+":"+user.getLinuxUsername()+" /home/"+user.getLinuxUsername()+"/ftp/files")
                .addUserInput("echo \""+user.getLinuxUsername()+"\" | sudo tee -a /etc/vsftpd.userlist")
                .addUserInput("usermod "+user.getLinuxUsername()+" -s /bin/ftponly")
                .addUserInput("systemctl restart vsftpd");

        LinuxTerminal terminal = new LinuxTerminal();
        terminal.setSession(session);
        terminal.executeSession();

        return true;
    }

    // TODO: Implement delete ftp account
}
