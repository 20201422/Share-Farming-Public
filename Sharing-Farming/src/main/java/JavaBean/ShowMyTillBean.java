package JavaBean;

import Model.Farming;
import Model.Land;

import java.sql.*;
import java.util.List;
import java.util.Objects;

public class ShowMyTillBean extends BaseDao{

    public List<Farming> ShowSFarming(String uno,String searchlna){//展示我的自行耕种土地
        if(Objects.equals(searchlna, "")){//无查询条件
            return queryForList(Farming.class, "select Farming.Lno,Lna,Lar,Lpr,Fday,Ftp,Lst,Lpo,Fst from Land,Farming where Land.Lno=Farming.Lno and Fst='自行耕种' and Farming.Uno=?", uno);
        }
        else{//有查询条件
            return queryForList(Farming.class, "select Farming.Lno,Lna,Lar,Lpr,Fday,Ftp,Lst,Lpo,Fst from Land,Farming where Land.Lno=Farming.Lno and Fst='自行耕种' and Farming.Uno=? and Land.Lna=?", uno,searchlna);
        }
    }//展示我的自行耕种土地

    public List<Farming> ShowMFarming(String uno,String searchlna){//展示我的托管代种土地
        if(Objects.equals(searchlna, "")){//无查询条件
            return queryForList(Farming.class, "select Farming.Lno,Lna,Lar,Lpr,Farming.Pno,Pna,Farming.Ano,Fday,Ftp,Lst,Lpo,Fst from Land,Farming,Plant where Land.Lno=Farming.Lno and Plant.Pno=Farming.Pno and Fst='托管代种' and Farming.Uno=?", uno);        }
        else{//有查询条件
            return queryForList(Farming.class, "select Farming.Lno,Lna,Lar,Lpr,Farming.Pno,Pna,Farming.Ano,Fday,Ftp,Lst,Lpo,Fst from Land,Farming,Plant where Land.Lno=Farming.Lno and Plant.Pno=Farming.Pno and Fst='托管代种' and Farming.Uno=? and Land.Lna=?", uno,searchlna);
        }
    }//展示我的托管代种土地

    public boolean SearchLand(String uno,String searchlna){//查找我的土地

        int flag=0;

        try {
//            Class.forName("org.h2.Driver");//.newInstance();
//            Connection conn = DriverManager.getConnection("jdbc:h2:/Users/coopskywalker/IdeaProjects/Sharing-Farming/GXNZ", "sa", "");
            Connection conn = JDBCUtils.getConn();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select Lna from Farming,Land where Farming.Lno=Land.Lno and Uno='"+uno+"'and Lna='"+searchlna+"'");//查询是否有该土地
            while (rs.next()){
                if(Objects.equals(searchlna, rs.getString(1))){//找到土地
                    flag=1;
                }
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(flag==1){//找到土地
            return true;
        }
        else{//未找到土地
            return false;
        }
    }//查找我的土地

//    public Farming SearchFarming(String lna){
//        return queryForOne(Farming.class, "select Farming.Lno,Lna,Lar,Lpr,Farming.Pno,Pna,Farming.Ano,Fday,Ftp,Lst,Lpo from Land,Farming,Plant,Fst where Land.Lno=Farming.Lno and Plant.Pno=Farming.Pno and Farming.Lna=?", lna);
//    }

//    @Test
//    public void test() {
//        System.out.println(queryForList(Farming.class, "select Farming.Lno,Lna,Lar,Lpr,Fday,Ftp,Lst from Land,Farming where Land.Lno=Farming.Lno and Fst='自行耕种' and Farming.Uno=?",  "003"));
//    }

}
