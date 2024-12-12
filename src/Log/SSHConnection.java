package Log;

import com.jcraft.jsch.*;

public class SSHConnection {
    private static final String HOST = "public-server";
    private static final int PORT = 22;
    private static final String USER = "root";
    private static final String PASSWORD = "D4*qaJh62n$n";

    public static Session connect() throws JSchException {
        JSch jsch = new JSch();
        Session session = jsch.getSession(USER, HOST, PORT);
        session.setPassword(PASSWORD);

        // SSH 연결 시 보안 경고 무시
        session.setConfig("StrictHostKeyChecking", "no");
        
        // 연결
        session.connect();
        
        return session;
    }
}
