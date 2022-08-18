import java.sql.Connection;

public class Demo04 {
    public static void main(String[] args) {
        DemoThread d1=new DemoThread();
        DemoThread d2=new DemoThread();
        DemoThread d3=new DemoThread();
        DemoThread d4=new DemoThread();
        d1.start();
        d2.start();  d3.start();  d4.start();
    }
}

class DemoThread extends  Thread{
    @Override
    public void run() {
//        super.run();
        try{
            Connection conn = DBUtils.getConn();
            System.out.println("获取到连接");
            Thread.sleep(5000);
            conn.close();
            System.out.println("归还连接");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}