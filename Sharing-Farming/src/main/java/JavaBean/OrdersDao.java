package JavaBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Goods;
import Model.Order;
public class OrdersDao extends BaseDao{

	
	public OrdersDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Order> getAllOrder(String uno)
	{
		List<Order> orderList=new ArrayList<Order>();
		try
		{
//		    Class.forName("org.h2.Driver");
//		    String url="jdbc:h2:/Users/coopskywalker/IdeaProjects/Sharing-Farming/GXNZ";
//		    String username="sa";
//		    String password="";
		    Connection conn=JDBCUtils.getConn();
		    Statement stmt=conn.createStatement();
		    ResultSet rs=null;
		    Statement stmt2=conn.createStatement();
		    ResultSet rs2=null;
		    Statement stmt3=conn.createStatement();
		    ResultSet rs3=null;
		    rs=stmt.executeQuery("SELECT * FROM Orders where Uno='"+uno+"'");
		   
		    while(rs.next()) 
		    {
		    	
		    	Order order=new Order();
		    	order.setOno(Integer.parseInt(rs.getString(1)));
		    	order.setQuHuoFangShi(Integer.parseInt(rs.getString(2)));
		    	order.setUno(rs.getString(3));
		    	order.setContact(rs.getString(4));
		    	order.setAddress(rs.getString(5));
		    	order.setPrice(Float.parseFloat(rs.getString(6)));
		    	order.setUName(rs.getString(7));
		    	 
		    	rs2=stmt2.executeQuery("SELECT * FROM ShopOrderDetails where Ono="+order.getOno());
		    	List<Goods> orderGoodsList=new ArrayList<Goods>();
		    	while(rs2.next()) 
		    	{
		    		Goods goods=new Goods();
		    		
		    		goods.setCna(rs2.getString(2));
			    	goods.setNum(Integer.parseInt(rs2.getString(3)));
			    	rs3=stmt3.executeQuery("SELECT Cpr,LocalUrl FROM Goods where Cna='"+goods.getCna()+"'");
			    	if(rs3.next())
			    	{
			    		goods.setCpr( Float.parseFloat(rs3.getString(1)));
				    	goods.setLocalUrl(rs3.getString(2));
			    	}
			    	else
			    		System.out.println("商品名称异常，不在库中");
			    	
			    	orderGoodsList.add(goods);
		    		
		    	}
		    	order.setOrderGoodsList(orderGoodsList);
		    	orderList.add(order);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return orderList;
		
	}
	
	public void insertOrder(String orderStr,Order order)
	{
		try
		{
//		    Class.forName("org.h2.Driver");
//		    String url="jdbc:h2:/Users/coopskywalker/IdeaProjects/Sharing-Farming/GXNZ";
//		    String username="sa";
//		    String password="";
		    Connection conn=JDBCUtils.getConn();
		    Statement stmt=conn.createStatement();
		    ResultSet rs=null;
		    
		    String sql = "INSERT INTO Orders(QuHuoFangShi, Uno, Contact,Address,Price,Uname) "
	+ "VALUES('"+order.getQuHuoFangShi()+"','"+order.getUno()+"','"+order.getContact()+"','"+order.getAddress()+"','"+order.getPrice()+"','"+order.getUName()+"')"; 
		    stmt.executeUpdate(sql);
		    rs=stmt.executeQuery("SELECT MAX(DISTINCT Ono) FROM Orders;");
	    	String Ono="";
		    if(rs.next())
		    {
		    	Ono=rs.getString(1);
		    }
		    String[] split = orderStr.split(",");
		    
		    for(int i=0;i<split.length;)
			{
		    	sql="INSERT INTO ShopOrderDetails VALUES("+Ono+",'"+split[i++]+"',"+Integer.parseInt(split[i++])+")"; 
		    	stmt.executeUpdate(sql);
			}
		    
		   
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void DeleteOrder(String Ono)
	{
//		try
//		{
//		    Class.forName("org.h2.Driver");
//		    String url="jdbc:h2:/Users/coopskywalker/IdeaProjects/Sharing-Farming/GXNZ";
//		    String username="sa";
//		    String password="";
//		    Connection conn=DriverManager.getConnection(url,username,password);
//		    Statement stmt=conn.createStatement();
//
//		    stmt.executeUpdate("DELETE FROM  Orders WHERE Ono='"+Ono+"'");
//		    stmt.executeUpdate("DELETE FROM  ShopOrderDetails WHERE Ono='"+Ono+"'");
//
//			stmt.close();
//			conn.close();
//		}catch(ClassNotFoundException e) {
//			e.printStackTrace();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
		update("DELETE FROM  Orders WHERE Ono=?",Ono);
		update("DELETE FROM  ShopOrderDetails WHERE Ono=?", Ono);
		
	}
	
	
}