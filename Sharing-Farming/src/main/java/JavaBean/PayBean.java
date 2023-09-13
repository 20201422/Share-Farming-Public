package JavaBean;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PayBean extends BaseDao{

    public void PayFarming(String lno){//支付
        update("update Land set Lst=3 where LNO=?",lno);
    }//支付

//    @Test
//    public void t() {
//        update("update Land set Lst=3 where LNO=?","240001");
//    }

}
