package org.itp.engine.useraccount;

public class UserAccount {

    String linuxUsername;
    String linuxPassword;
    String ftpUsername;
    String ftpPassword;
    String dbUsername;
    String dbPassword;
    String fileBrowserUsername;
    String fileBrowserPassword;
    String fileBrowserPort;
    String fileBrowserBasePath;

    public UserAccount() {
    }

    public UserAccount(
            String linuxUsername,
            String linuxPassword,
            String ftpUsername,
            String ftpPassword,
            String dbUsername,
            String dbPassword,
            String fileBrowserUsername,
            String fileBrowserPassword,
            String fileBrowserPort,
            String fileBrowserBasePath
    ) {
        this.linuxUsername = linuxUsername;
        this.linuxPassword = linuxPassword;
        this.ftpUsername = ftpUsername;
        this.ftpPassword = ftpPassword;
        this.dbUsername = dbUsername;
        this.dbPassword = dbPassword;
        this.fileBrowserUsername = fileBrowserUsername;
        this.fileBrowserPassword = fileBrowserPassword;
        this.fileBrowserPort = fileBrowserPort;
        this.fileBrowserBasePath = fileBrowserBasePath;
    }

    public String getLinuxUsername() {
        return linuxUsername;
    }

    public void setLinuxUsername(String linuxUsername) {
        this.linuxUsername = linuxUsername;
    }

    public String getLinuxPassword() {
        return linuxPassword;
    }

    public void setLinuxPassword(String linuxPassword) {
        this.linuxPassword = linuxPassword;
    }

    public String getFtpUsername() {
        return ftpUsername;
    }

    public void setFtpUsername(String ftpUsername) {
        this.ftpUsername = ftpUsername;
    }

    public String getFtpPassword() {
        return ftpPassword;
    }

    public void setFtpPassword(String ftpPassword) {
        this.ftpPassword = ftpPassword;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getFileBrowserUsername() {
        return fileBrowserUsername;
    }

    public void setFileBrowserUsername(String fileBrowserUsername) {
        this.fileBrowserUsername = fileBrowserUsername;
    }

    public String getFileBrowserPassword() {
        return fileBrowserPassword;
    }

    public void setFileBrowserPassword(String fileBrowserPassword) {
        this.fileBrowserPassword = fileBrowserPassword;
    }

    public String getFileBrowserPort() {
        return fileBrowserPort;
    }

    public void setFileBrowserPort(String fileBrowserPort) {
        this.fileBrowserPort = fileBrowserPort;
    }

    public String getFileBrowserBasePath() {
        return fileBrowserBasePath;
    }

    public void setFileBrowserBasePath(String fileBrowserBasePath) {
        this.fileBrowserBasePath = fileBrowserBasePath;
    }
}
