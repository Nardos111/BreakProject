import java.sql.*;

public class PomodoroDatabase {
    private static Connection connection;
    private final String NAME = "pomodoro";
    Statement statement;
    public static void main(String[] args) {



    }
    public void prepareDatabase() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "1234");
        Statement statement = connection.createStatement();
    }
    public void createDatabase() throws SQLException {
        statement.executeUpdate("create database" + NAME);
    }
    public ResultSet executeRequest(String s) throws SQLException {
        return statement.executeQuery(s);
    }
}
