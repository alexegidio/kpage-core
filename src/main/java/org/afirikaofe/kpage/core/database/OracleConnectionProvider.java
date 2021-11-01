package org.afirikaofe.kpage.core.database;

import org.afirikaofe.kpage.core.exception.UnrecoverableException;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnectionProvider implements ConnectionProvider {

    public static final String JDBC_ORACLE_CONNECTION_STRING = "jdbc:oracle:thin:@%s:1521:%s";

    @Override
    public Connection getConnection() {
        try (Connection conn = DriverManager.getConnection(
                String.format(JDBC_ORACLE_CONNECTION_STRING, Configuration.getInstance().getJdbcUrl(),
                        Configuration.getInstance().getDbName()), Configuration.getInstance().getDbUserName(),
                Configuration.getInstance().getDbPassword())) {
            if (conn != null) {
                return conn;
            } else {
                throw new UnrecoverableException("Error on connect to database");
            }
        } catch (Exception e) {
            throw new UnrecoverableException("Error on connect to database", e);
        }
    }


}
