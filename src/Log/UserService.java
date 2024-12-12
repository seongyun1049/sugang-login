package Log;

import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserService {
    public static boolean registerUser(String id, String pw) throws SQLException {
        String hashedPassword = BCrypt.hashpw(pw, BCrypt.gensalt());
        
        try (Connection conn = MySQLConnection.getConnection()) {
            String query = "INSERT INTO user (id, pw) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, id);
                stmt.setString(2, hashedPassword);
                int result = stmt.executeUpdate();
                return result > 0; // 성공적으로 삽입되었으면 true 반환
            }
        }
    }
    public static boolean authenticateUser(String id, String pw) throws SQLException {
        try (Connection conn = MySQLConnection.getConnection()) {
            String query = "SELECT pw FROM user WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        String storedPassword = rs.getString("password");
                        return BCrypt.checkpw(pw, storedPassword); // 비밀번호 비교
                    }
                    return false; // 사용자 이름이 존재하지 않으면 false
                }
            }
        }
    }
}


 
