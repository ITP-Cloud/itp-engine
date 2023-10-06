package org.itp.engine.database;

public class Database {

    String databaseName;

    public Database() {
    }


    public Database(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
}
