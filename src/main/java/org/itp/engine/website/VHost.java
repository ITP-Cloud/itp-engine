package org.itp.engine.website;

public class VHost {
    private String port;
    private String documentRoot;
    private boolean hasPublicFolder;

    public VHost() {
    }

    public VHost(String port, String documentRoot, boolean hasPublicFolder) {
        this.port = port;
        this.documentRoot = documentRoot;
        this.hasPublicFolder = hasPublicFolder;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDocumentRoot() {
        return documentRoot;
    }

    public void setDocumentRoot(String documentRoot) {
        this.documentRoot = documentRoot;
    }

    public boolean isHasPublicFolder() {
        return hasPublicFolder;
    }

    public void setHasPublicFolder(boolean hasPublicFolder) {
        this.hasPublicFolder = hasPublicFolder;
    }

    public String generateVhostContent() {
        if (hasPublicFolder) {
            return "<VirtualHost *:" + this.port + ">\n" +
                    "        ServerAdmin webmaster@localhost\n" +
                    "        DocumentRoot " + this.documentRoot + "/public \n" +
                    "\n" +
                    "\n" +
                    "        <Directory " + this.documentRoot + ">\n" +
                    "                Options Indexes FollowSymLinks\n" +
                    "                AllowOverride All\n" +
                    "                Require all granted\n" +
                    "        </Directory>\n" +
                    "\n" +
                    "\n" +
                    "        ErrorLog ${APACHE_LOG_DIR}/error.log\n" +
                    "        CustomLog ${APACHE_LOG_DIR}/access.log combined\n" +
                    "</VirtualHost>";
        } else {
            return "<VirtualHost *:" + this.port + ">\n" +
                    "        ServerAdmin webmaster@localhost\n" +
                    "        DocumentRoot " + this.documentRoot + " \n" +
                    "\n" +
                    "\n" +
                    "        <Directory " + this.documentRoot + ">\n" +
                    "                Options Indexes FollowSymLinks\n" +
                    "                AllowOverride All\n" +
                    "                Require all granted\n" +
                    "        </Directory>\n" +
                    "\n" +
                    "\n" +
                    "        ErrorLog ${APACHE_LOG_DIR}/error.log\n" +
                    "        CustomLog ${APACHE_LOG_DIR}/access.log combined\n" +
                    "</VirtualHost>";
        }
    }
}
