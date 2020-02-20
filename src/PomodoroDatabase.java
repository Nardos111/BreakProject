import java.sql.*;

public class PomodoroDatabase {
    static Connection connection;
    private final String NAME = "pomodoro";
    static Statement statement;
    public static void main(String[] args) {



    }
    public ResultSet retrieveRows() throws SQLException {
        prepareDatabase();
        return statement.executeQuery("select * from Profile;");
    }
    public void prepareDatabase() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost/Pomodoro", "root", "1234");
        statement = connection.createStatement();
    }
    public void createDatabase() throws SQLException {
        statement.executeUpdate("create database" + NAME);
        statement.executeQuery("create table Pomodoro_Session (pomodoro_id INT PRIMARY KEY, time_started DATE, time_ended DATE);");
        statement.executeQuery("create table Profile (profile_id VARCHAR(255) PRIMARY KEY, profile_name VARCHAR(255), profile_color VARCHAR(255),session_time INT, break_time INT);");
    }
    public static ResultSet executeRequest(String s) throws SQLException {
        return statement.executeQuery(s);
    }
    public void insertProfile(Profile profile) throws SQLException {
        prepareDatabase();

        String sql = String.format("INSERT INTO Profile VALUES ('%s', '%s', '%s', %s, %s);", profile.getProfileID(), profile.getProfileName(), profile.getProfileColor(), profile.getSessionTimeInMins(), profile.getBreakTimeInMins());

        statement.executeLargeUpdate(sql);
    }
}
