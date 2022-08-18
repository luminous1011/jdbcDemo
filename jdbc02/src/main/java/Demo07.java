import java.sql.*;
import java.util.Scanner;

public class Demo07 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("name:");
        String name = scanner.nextLine();
        System.out.println("password:");
        String pwd =scanner.nextLine();

        Connection conn = DBUtils.getConn();
        PreparedStatement statement= conn.prepareStatement("select count(*) from  user where username=? and password=?");
        statement.setString(1,name);
        statement.setString(2,pwd);
        ResultSet rs =  statement.executeQuery();
        System.err.println(rs);
        DatabaseMetaData dbData= conn.getMetaData();
        System.err.println(dbData.getUserName());
        ResultSetMetaData dd = statement.getMetaData();
        System.err.println(dd.getColumnCount());
 
        statement.close();
        conn.close();

    }
}