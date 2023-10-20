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
                .getSessionWith("bash");

        session
                // Step 1: Create ftp directory
                .addUserInput("mkdir /home/" + user.getFtpUsername() + "/ftp")
                // Step 2: Set ownership, I also don't know why, but for security stuff I guess
                .addUserInput("chown nobody:nogroup /home/" + user.getFtpUsername() + "/ftp")
                .addUserInput("chmod a-w /home/" + user.getFtpUsername() + "/ftp")
                // Step 3: Create the websites directory
                .addUserInput("mkdir /home/" + user.getFtpUsername() + "/ftp/websites")
                // Step 4: Create a shared group, for the new user and www-data aka apache2
                .addUserInput("groupadd " + user.getFtpUsername() + "_n_www-data")
                // Step 5: Add apache2 to the new shared group
                .addUserInput("usermod -aG " + user.getFtpUsername() + "_n_www-data www-data")
                // Step 6: Add user to the new shared group
                .addUserInput("usermod -aG " + user.getFtpUsername() + "_n_www-data " + user.getFtpUsername())
                // Step 7: Change ownership of the user's website directory, more security stuff
                // The commands below supplement the vsftp configurations. They allow the user to upload
                // files with group permissions applied already. This makes it possible for
                // apache to scan the folder respond to requests.

                .addUserInput("chown -R www-data:" + user.getFtpUsername() + "_n_www-data /home/" + user.getFtpUsername())
                .addUserInput("chmod 770 /home/" + user.getFtpUsername() + "/ftp/websites")
                .addUserInput("chgrp -R " + user.getFtpUsername() + "_n_www-data /home/" + user.getFtpUsername() + "/ftp/websites")
                .addUserInput("chmod -R g+w /home/" + user.getFtpUsername() + "/ftp/websites")
                .addUserInput("find /home/" + user.getFtpUsername() + "/ftp/websites -type d -exec chmod 2770 {} \\;")
                .addUserInput("find /home/" + user.getFtpUsername() + "/ftp/websites -type f -exec chmod ug+rw {} \\;")

                // Allow the group to write to the websites, this is primarily for the user, since the apache2 user already has access
                .addUserInput("chmod g+w -R /home/" + user.getFtpUsername() + "/ftp/websites")
                // Step 8: Grant user ftp access
                .addUserInput("echo \""+user.getFtpUsername()+"\" | sudo tee -a /etc/vsftpd.userlist")
                // Step 9: Limit user terminal access
                .addUserInput("usermod "+user.getFtpUsername()+" -s /bin/ftponly")
                // Step 10: Cleanup
                .addUserInput("systemctl restart vsftpd");

        LinuxTerminal terminal = new LinuxTerminal();
        terminal.setSession(session);
        System.out.println(terminal.executeSession());

        return true;
    }

    // TODO: Implement delete ftp account
}
