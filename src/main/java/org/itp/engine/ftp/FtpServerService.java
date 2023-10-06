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
                .addUserInput("mkdir /home/"+user.getFtpUsername()+"/ftp")
                .addUserInput("chown nobody:nogroup /home/"+user.getFtpUsername()+"/ftp")
                .addUserInput("chmod a-w /home/"+user.getFtpUsername()+"/ftp")
                .addUserInput("mkdir /home/"+user.getFtpUsername()+"/ftp/websites")
                .addUserInput("chown "+user.getFtpUsername()+":"+user.getFtpUsername()+" /home/"+user.getFtpUsername()+"/ftp/files")
                .addUserInput("echo \""+user.getFtpUsername()+"\" | sudo tee -a /etc/vsftpd.userlist")
                .addUserInput("usermod "+user.getFtpUsername()+" -s /bin/ftponly")
                .addUserInput("systemctl restart vsftpd");

        LinuxTerminal terminal = new LinuxTerminal();
        terminal.setSession(session);
        terminal.executeSession();

        return true;
    }

    // TODO: Implement delete ftp account
}
