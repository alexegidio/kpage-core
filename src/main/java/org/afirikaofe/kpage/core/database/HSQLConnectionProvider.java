package org.afirikaofe.kpage.core.database;

import org.afirikaofe.kpage.core.exception.UnrecoverableException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HSQLConnectionProvider implements ConnectionProvider {

    public static final String JDBC_HSQLDB_CONNECTION_STRING = "jdbc:hsqldb://%s/%s";

    @Override
    public Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(String.format(JDBC_HSQLDB_CONNECTION_STRING,
                            Configuration.getInstance().getDbName(), Configuration.getInstance().getDbUserName()),
                    "SA", "");
            if (conn != null) {
                return conn;
            } else {
                throw new UnrecoverableException("Error on connect to database");
            }
        } catch (SQLException e) {
            throw new UnrecoverableException("Error on connect to database", e);
        }
    }
}
