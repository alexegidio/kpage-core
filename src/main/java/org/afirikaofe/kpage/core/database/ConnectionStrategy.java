package org.afirikaofe.kpage.core.database;

import org.afirikaofe.kpage.core.exception.UnrecoverableException;

import java.util.Collections;
import java.util.Map;

public class ConnectionStrategy {

    private static ConnectionStrategy instance;

    private Map<DatabaseProvider, ConnectionProvider> providers;

    public static final ConnectionStrategy getInstance() {
        if (instance == null) {
            instance = new ConnectionStrategy();
        }
        return instance;
    }

    public ConnectionProvider retrieveConnectionProvider(String databaseProvider) {
        DatabaseProvider key = DatabaseProvider.valueOf(databaseProvider);
        if (getConnectionProviders().containsKey(key)) {
            return getConnectionProviders().get(key);
        }
        throw new UnrecoverableException(String.format("There is no connection provider implementation for " +
                "databaseProvider %s", databaseProvider));
    }

    public Map<DatabaseProvider, ConnectionProvider> getConnectionProviders() {

        if (providers == null) {
            providers =
                    Collections.singletonMap(DatabaseProvider.ORACLE, new OracleConnectionProvider());
            providers.put(DatabaseProvider.HSQL, new HSQLConnectionProvider());

        }
        return providers;
    }
}
