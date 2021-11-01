package org.afirikaofe.kpage.core.database;

import java.sql.Connection;

public interface ConnectionProvider {
    Connection getConnection();
}
