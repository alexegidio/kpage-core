package org.afirikaofe.kpage.core.database;

import org.afirikaofe.kpage.core.exception.UnrecoverableException;
import org.afirikaofe.kpage.core.model.Page;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBasePageFetcher implements PageFetcher {

    private final static String queryTaskByName = "SELECT %s, %s FROM PAGINATION WHERE TASK_NAME=%s";

    private String taskNameColumn;

    private String lastPageColumn;

    public DataBasePageFetcher(String taskNameColumn, String lastPageColumn) {
        this.taskNameColumn = taskNameColumn;
        this.lastPageColumn = lastPageColumn;
    }

    public DataBasePageFetcher() {
    }

    @Override
    public Page fetchPageFromDb(String taskName) {

        String query = String.format(getTaskName(), getLastColumn(), queryTaskByName, taskName);

        Connection con = getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            Page page = new Page();
            page.setFirstPage(rs.getInt(1));
            return page;
        } catch (SQLException e) {
            throw new UnrecoverableException("Wasn't able to connect to database. Check your database setup!", e);
        }
    }

    private String getLastColumn() {
        if (lastPageColumn.isBlank()) {
            return "LAST_PAGE";
        }
        return lastPageColumn;
    }

    private String getTaskName() {
        if (taskNameColumn.isBlank()) {
            return "TASK_NAME";
        }
        return taskNameColumn;
    }

    private Connection getConnection() {
        ConnectionProvider connectionProvider = ConnectionStrategy.getInstance().retrieveConnectionProvider(Configuration.getInstance().
                getDatabaseProvider());
        return connectionProvider.getConnection();
    }
}
