import org.apache.commons.dbcp.BasicDataSource;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils {
    public static String dirver;
    public static String username;
    public static String url;
    public static String password;
    public static BasicDataSource bs;

    static {
        Properties prop =new Properties();
        InputStream ips = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try{
            prop.load(ips);
            dirver = prop.getProperty("dirver");
            username = prop.getProperty("username");
            url = prop.getProperty("url");
            password = prop.getProperty("password");
            bs = new BasicDataSource();
            bs.setDriverClassName(dirver);
            bs.setUrl(url);
            bs.setUsername(username);
            bs.setPassword(password);
            bs.setInitialSize(3);
            bs.setMaxActive(3);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                ips.close();
            }catch (IOException e){
                e.printStackTrace();

            }
        }
    }

    public  static Connection getConn() throws  Exception{
//        Class.forName(dirver);
//        return DriverManager.getConnection(url,username,password);
        return  bs.getConnection();
    }

    public static void close(Connection conn, Statement state, ResultSet rs){
        try{
            if(rs!=null){
                rs.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            state.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
