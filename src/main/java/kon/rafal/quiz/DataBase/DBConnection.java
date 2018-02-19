package kon.rafal.quiz.DataBase;

import java.sql.*;

public class DBConnection {

    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/quiz?autoReconnect=true&useSSL=false";
    public static Connection connection = null;

    public static void dbConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            Statement statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Invalid database configuration");
            e.printStackTrace();
        }
    }

    public static void dbConnectionClose() throws Exception {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    public ResultSet dbExecuteQuery(String queryStatment) throws Exception {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            dbConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryStatment);
        } catch (SQLException ex) {
            System.out.println("Error");
            throw ex;
        }
        return resultSet;
    }

    public ResultSet dbExecuteUpdateQuery(String queryStatment) throws SQLException {
        Statement statement = null;
        try {
            dbConnection();
            statement = connection.createStatement();
            statement.executeUpdate(queryStatment);
            System.out.println("A new object has been added successfully");
        } catch (SQLException e) {
            System.out.println("Sql command error");
        }
        return null;
    }
}
