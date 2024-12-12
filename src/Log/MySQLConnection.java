package Log;

import java.sql.*;

public class MySQLConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/MySQL91";
    private static final String USER = "root";
    private static final String PASSWORD = "Tkfkdgo1_0";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

