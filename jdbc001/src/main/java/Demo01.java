import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2. 获取连接对象
        try{
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbc01","root","123456");
            System.out.println(conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
