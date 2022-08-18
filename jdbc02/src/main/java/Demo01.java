import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo01 {
    @Test
    public void select(){
        Connection conn =null;
        Statement state =null;
        ResultSet rs =null;
        try{
            conn = DBUtils.getConn();
            state = conn.createStatement();
            rs= state.executeQuery("select * from jdbc");
            while(rs.next()){
                System.out.println(rs.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.close(conn,state,rs);
        }
    }
}
