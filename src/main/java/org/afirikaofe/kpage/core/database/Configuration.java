package org.afirikaofe.kpage.core.database;

import org.afirikaofe.kpage.infrastructure.PropertiesLoader;

public class Configuration {

    public static Configuration instance;

    public String databaseProvider;

    private String jdbcUrl;

    private String dbName;

    private String dbUserName;

    private String dbPassword;

    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    public String getDatabaseProvider() {
        return databaseProvider;
    }

    public String getJdbcUrl() {
        if (jdbcUrl == null) {
            jdbcUrl = PropertiesLoader.getInstance().get("db.url").toString();
        }
        return jdbcUrl;
    }

    public String getDbName() {
        if (dbName == null) {
            dbName = PropertiesLoader.getInstance().get("db.name").toString();
        }
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbUserName() {
        if (dbUserName == null) {
            dbUserName = PropertiesLoader.getInstance().get("db.user").toString();
        }
        return dbUserName;
    }

    public String getDbPassword() {
        if (dbPassword == null) {
            dbPassword = PropertiesLoader.getInstance().get("db.password:").toString();
        }
        return dbPassword;
    }
}
