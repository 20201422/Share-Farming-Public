package JavaBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.Goods;

public class GoodsDao extends BaseDao
{
	private List<Goods> goodsList;

	

	public GoodsDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Goods> getGoodsList() {
		
//		goodsList=new ArrayList<Goods>();
//		try
//		{
//		    Class.forName("org.h2.Driver");
//		    String url="jdbc:h2:/Users/coopskywalker/IdeaProjects/Sharing-Farming/GXNZ";
//		    String username="sa";
//		    String password="";
//		    Connection conn=JDBCUtils.getConn();
//		    Statement stmt=conn.createStatement();
//			ResultSet rs=stmt.executeQuery("select * from Goods");
//		    while(rs.next())
//		    {
//
//		    	Goods goods=new Goods();
//		    	goods.setCna(rs.getString(1));
//		    	goods.setCpr( Float.parseFloat(rs.getString(2)));
//		    	goods.setLocalUrl(rs.getString(3));
//		    	goodsList.add(goods);
//			}
//			rs.close();
//			stmt.close();
//			conn.close();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
		return queryForList(Goods.class, "select * from Goods");
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
	
}