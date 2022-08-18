import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2. 获取连接对象
        try{
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbc01?useSSL=false&serverTimezone=UTC","root","123456");
            System.out.println(conn);

            //3.创建sql语句执行对象
            Statement statement = conn.createStatement();

            //4.执行sql
            String sql = "create table if not exists jdbc(id int ,name varchar(10))";
            statement.execute(sql);
            statement.execute("drop table jdbc");
            System.out.println("create success");
            statement.close();
            conn.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
