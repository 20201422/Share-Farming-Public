package JavaBean;

import Model.Farming;
import Model.Plant;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TillOrderBean extends BaseDao{

    public List<Plant> ShowPlant(){//展示植物
        return queryForList(Plant.class, "select Pno,Pna from Plant");
    }//展示植物

    public void TillSFarming(String lno,String uno,String fday,String ftp,String fst){//自行耕种
        update("insert into Farming values(?,?,'','',?,?,?);",lno,uno,fday,ftp,fst);
        update("update Land set Lst=1 where LNO=?;",lno);
    }//自行耕种

    public void TillMFarming(String lno,String uno,String pno,String fday,String ftp,String fst){//托管代种
        update("insert into Farming values(?,?,'',?,?,?,?)",lno,uno,pno,fday,ftp,fst);
        update("update Land set Lst=1 where LNO=?",lno);
    }//托管代种

    public void TillAgain(String lno,String fday,String pno,String ftp){//续租
        update("update Farming set Fday=?,Pno=?,Ftp=? where LNO=? ;",fday,pno,ftp,lno);
    }//续租

}
