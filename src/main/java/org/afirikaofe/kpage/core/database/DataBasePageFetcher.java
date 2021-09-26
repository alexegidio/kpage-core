package org.afirikaofe.kpage.core.database;

import org.afirikaofe.kpage.core.model.Page;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBasePageFetcher implements PageFetcher {

    //TODO customize column names
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
            //TODO HANDLE EXCEPTION
            e.printStackTrace();
        }
        return null;
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
        //TODO implement connection
        return null;
    }
}
