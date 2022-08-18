import java.sql.Connection;

public class Demo03 {
    public static void main(String[] args) throws Exception {
        Connection c1 =DBUtils.getConn();
        System.err.println(1);
        Connection c2 =DBUtils.getConn();
        System.err.println(2);
        Connection c3 =DBUtils.getConn();
        System.err.println(3);
        c1.close();
        Connection c4 =DBUtils.getConn();
        System.err.println(4);

    }
}
