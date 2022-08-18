import org.junit.Test;

import java.sql.*;

public class DBUtils {
    //获取连接
    @Test
    public static Connection getConn() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbc01?useSSL=false&serverTimezone=UTC","root","123456");
    }

    //关闭资源
    public  static void close(Connection conn, Statement state, ResultSet rs){
        try{
            if(rs != null){
                rs.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if(rs != null){
                state.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if(rs != null){
                conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
