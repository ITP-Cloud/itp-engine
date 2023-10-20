package org.itp.engine.website;

import org.itp.engine.linuxos.LinuxTerminal;
import org.itp.engine.linuxos.TerminalOperationSession;
import org.itp.engine.linuxos.TerminalOperationSessionFactory;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class WebsiteService {
    public void createWebsite(Website website) {

        try {
            // Step 1: Create and Add content to new vhost file
            VHost newVhost = new VHost(
                    website.getPortNumber(),
                    website.getWebsiteAbsolutePath()
            );

            FileWriter writer =
                    new FileWriter("/etc/apache2/sites-available/" + website.getVhostIdentifier() + ".conf");

            writer.write(newVhost.generateVhostContent());
            writer.flush();
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        TerminalOperationSession session = TerminalOperationSessionFactory
                .getSessionWith("bash");
        session
                // Step 2: Create Website Folder
                .addUserInput("mkdir " + website.getWebsiteAbsolutePath())
                // Step 3: Permission and ownership
                .addUserInput("chown www-data:" + website.getLinuxUser() + "_n_www-data -R " + website.getWebsiteAbsolutePath())
                .addUserInput("chmod 770 -R " + website.getWebsiteAbsolutePath())

                // Step 4: Add default index page
                .addUserInput("cp /home/aaron/index.html " + website.getWebsiteAbsolutePath() + "/index.html")
                // Step 5: Allow traffic through designated port
                .addUserInput("ufw allow " + website.getPortNumber())
                // Step 6: Add port to apache ports as well
                .addUserInput("echo \"Listen " + website.getPortNumber() + "\" | sudo tee -a /etc/apache2/ports.conf")
                // Step 7: Activate vhost
                .addUserInput("a2ensite " + website.getVhostIdentifier() + ".conf")
                // Step 8: Reload apache
                .addUserInput("systemctl reload apache2");

        LinuxTerminal terminal = new LinuxTerminal();
        terminal.setSession(session);
        terminal.executeSession();

    }
}
