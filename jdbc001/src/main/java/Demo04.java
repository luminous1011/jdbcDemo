import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Demo04 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        InputStream ips = Demo04.class.getClassLoader().getResourceAsStream("jdbc.properties");
        System.out.println(prop);
        try
        {
            prop.load(ips);

            System.out.println(prop.getProperty("name","utf-8"));
            System.out.println(prop.getProperty("age"));
            System.out.println(prop.getProperty("username"));
            System.out.println(prop.getProperty("url"));
            System.out.println(prop.getProperty("password"));
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
