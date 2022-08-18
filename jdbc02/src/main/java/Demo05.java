import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("name:");
        String name = scanner.nextLine();
        System.out.println("age:");
        int age =scanner.nextInt();

        String sql = "insert  into jdbcuser values(?,?)";
        Connection conn = DBUtils.getConn();
        PreparedStatement statement= conn.prepareStatement(sql);
        statement.setString(1,name);
        statement.setInt(2,age);
        statement.executeUpdate();
        statement.close();
        conn.close();

    }
}
