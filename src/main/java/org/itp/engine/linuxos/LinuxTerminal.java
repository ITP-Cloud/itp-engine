package org.itp.engine.linuxos;

import java.io.*;
import java.util.List;

public class LinuxTerminal {

    private TerminalOperationSession session;
    private StringBuilder sessionOutput;

    public LinuxTerminal() {
    }

    public void setSession(TerminalOperationSession session) {
        this.session = session;
    }

    public void executeSession(){
        try {

            String[] command = this.session.getInitialCommand().split(" "); 
            ProcessBuilder builder = new ProcessBuilder(command);
            Process process = builder.start();

            OutputStream stdin = process.getOutputStream();
            InputStream stdout = process.getInputStream();
            InputStream stderr = process.getErrorStream();

            // Store the input and output streams in a buffer
            BufferedReader reader = new BufferedReader(new InputStreamReader(stdout));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stdin));
            BufferedReader error = new BufferedReader(new InputStreamReader(stderr));

            // Send inputs
            List<String> userInputs = this.session.getUserInputs();
            for (String input :
                    userInputs) {
                writer.write(input + " \n");
                writer.flush();
            }

            writer.close();

            // Display the output
            String line;
            while ((line = reader.readLine()) != null) this.sessionOutput.append(line);
            // Display any errors
            while ((line = error.readLine()) != null) this.sessionOutput.append(line);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StringBuilder getSessionOutput() {
        return sessionOutput;
    }
}