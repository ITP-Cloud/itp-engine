package org.itp.engine.website;

public class Website {
    private String linuxUser;
    private String portNumber;
    private String vhostIdentifier;
    private String websiteAbsolutePath;

    private boolean hasPublicFolder;

    public Website() {
    }

    public Website(
            String linuxUser,
            String portNumber,
            String vhostIdentifier,
            String websiteAbsolutePath,
            boolean hasPublicFolder
    ) {
        this.linuxUser = linuxUser;
        this.portNumber = portNumber;
        this.vhostIdentifier = vhostIdentifier;
        this.websiteAbsolutePath = websiteAbsolutePath;
        this.hasPublicFolder = hasPublicFolder;
    }

    public String getLinuxUser() {
        return linuxUser;
    }

    public void setLinuxUser(String linuxUser) {
        this.linuxUser = linuxUser;
    }

    public String getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }

    public String getVhostIdentifier() {
        return vhostIdentifier;
    }

    public void setVhostIdentifier(String vhostIdentifier) {
        this.vhostIdentifier = vhostIdentifier;
    }

    public String getWebsiteAbsolutePath() {
        return websiteAbsolutePath;
    }

    public void setWebsiteAbsolutePath(String websiteAbsolutePath) {
        this.websiteAbsolutePath = websiteAbsolutePath;
    }

    public boolean hasPublicFolder() {
        return hasPublicFolder;
    }

    public void setHasPublicFolder(boolean hasPublicFolder) {
        this.hasPublicFolder = hasPublicFolder;
    }
}
