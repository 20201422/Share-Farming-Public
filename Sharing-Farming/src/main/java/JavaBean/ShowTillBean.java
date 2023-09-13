package JavaBean;

import Model.Land;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShowTillBean extends BaseDao{

    public List<Land> ShowLand(){//展示土地
        return queryForList(Land.class, "select Lno,Lna,Lst,Lpr,Lar,Lpo,Lmg from Land");
    }//展示土地

}
