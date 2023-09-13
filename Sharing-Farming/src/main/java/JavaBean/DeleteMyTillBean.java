package JavaBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import org.junit.Test;

public class DeleteMyTillBean extends BaseDao{

    public void DeleteFarming(String uno,String lno,String fst) {//取消耕种
        update("delete from Farming where Lno=? and UNO=? ;", lno, uno);//删除数据在耕种表
        update("update Land set Lst=0 where LNO=? ;", lno);//更新土地状态
        if(Objects.equals(fst, "托管代种")){//耕种类型为托管代种
            update("delete from Report where Lno=?;", lno);//删除报告
        }
    }//取消耕种

//    @Test
//    public void test() {
//        System.out.println(update("delete from Farming where LNO=? and UNO=?", "240001", "001"));
//    }

}
