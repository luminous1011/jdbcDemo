import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Demo02 {
    public static String dirver;
    public static String username;
    public static String url;
    public static String password;
    static{
        Properties prop =new Properties();
        InputStream ips = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try{
            prop.load(ips);
            dirver = prop.getProperty("dirver");
            username = prop.getProperty("username");
            url = prop.getProperty("url");
            password = prop.getProperty("password");
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
    public static void main(String[] args) throws SQLException {
        BasicDataSource ds= new BasicDataSource();
        ds.setDriverClassName(dirver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setInitialSize(3);
        ds.setMaxActive(5);
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
