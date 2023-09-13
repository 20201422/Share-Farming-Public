package JavaBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Model.Goods;
import Model.ShopCar;

public class ShopCarDao {
	ShopCar car;
	public ShopCarDao() {
		// TODO Auto-generated constructor stub
		 
	}
	
	
	public ShopCar getCar(String Uno) {
		car=new  ShopCar();
		car.setUno(Uno);
		try
		{
//		    Class.forName("org.h2.Driver");
//		    String url="jdbc:h2:/Users/coopskywalker/IdeaProjects/Sharing-Farming/GXNZ";
//		    String username="sa";
//		    String password="";
		    Connection conn=JDBCUtils.getConn();
		    Statement stmt=conn.createStatement();
		    ResultSet rs=null;
		    rs=stmt.executeQuery("SELECT ShopCar.Cna,Cpr,LocalUrl,ShopCar.Num"
		    		+ "	FROM Goods,ShopCar"
		    		+ "	WHERE ShopCar.Cna=Goods.Cna AND Uno='"+Uno+"'");
		    while(rs.next()) 
		    {
		    	
		    	Goods goods=new Goods();
		    	goods.setCna(rs.getString(1));
		    	goods.setCpr( Float.parseFloat(rs.getString(2)));
		    	goods.setLocalUrl(rs.getString(3));
		    	goods.setNum(Integer.parseInt(rs.getString(4)));
		    	car.getGoodsList().add(goods);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return car;
	}

	
	public void AddCar(Goods goods,String Uno) {
		try
		{
//			Class.forName("org.h2.Driver");
//		    String url="jdbc:h2:/Users/coopskywalker/IdeaProjects/Sharing-Farming/GXNZ";
//		    String username="sa";
//		    String password="";
		    Connection conn=JDBCUtils.getConn();
		    Statement stmt=conn.createStatement();
		    ResultSet rs=null;
		    rs=stmt.executeQuery("SELECT * FROM ShopCar WHERE Cna='"+goods.getCna()+"' and Uno='"+Uno+"'");
		    		
		    
		    if(rs.next())
		    {
		    	int num=Integer.parseInt(rs.getString(3));
		    	num=goods.getNum();
		    	String sql = "UPDATE ShopCar SET Num="+num+"  WHERE Cna='"+goods.getCna()+"' and Uno='"+Uno+"'";
		    	stmt.executeUpdate(sql);
		    	
		    }
		    else
		    {
		    	String sql = "INSERT INTO ShopCar VALUES('"+Uno+"','"+goods.getCna()+"','"+goods.getNum()+"')"; 
		    	stmt.executeUpdate(sql);
		    }
		   
			stmt.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	
	
	
	public void UpdateCar(ShopCar shopCar) {
		try
		{
//			Class.forName("org.h2.Driver");
//		    String url="jdbc:h2:/Users/coopskywalker/IdeaProjects/Sharing-Farming/GXNZ";
//		    String username="sa";
//		    String password="";
		    Connection conn=JDBCUtils.getConn();
		    Statement stmt=conn.createStatement();
		    ResultSet rs=null;
		    
		    int size=0;
		    if(shopCar.getGoodsList()!=null)
		    	size=shopCar.getGoodsList().size();
		   
		    	
		    List<Goods> ShopCarList=shopCar.getGoodsList();
		    String Uno=shopCar.getUno();
		    for(int j=0;j<size;j++)
		    {
		    	Goods goods=ShopCarList.get(j);
		    	rs=stmt.executeQuery("SELECT * FROM ShopCar WHERE Cna='"+goods.getCna()+"' and Uno='"+Uno+"'");
	    		
			    
			    if(rs.next())
			    {
			    	int num=Integer.parseInt(rs.getString(3));
			    	num=goods.getNum();
			    	String sql = "UPDATE ShopCar SET Num="+num+"  WHERE Cna='"+goods.getCna()+"' and Uno='"+Uno+"'";
			    	stmt.executeUpdate(sql);
			    	
			    }
			    else
			    {
			    	String sql = "INSERT INTO ShopCar VALUES('"+Uno+"','"+goods.getCna()+"','"+goods.getNum()+"')"; 
			    	stmt.executeUpdate(sql);
			    }
		    	
		    	
		    }
		    
		   
			stmt.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public void DeleteGoods(ShopCar shopCar) 
	{
		try
		{
//		    Class.forName("org.h2.Driver");
//		    String url="jdbc:h2:/Users/coopskywalker/IdeaProjects/Sharing-Farming/GXNZ";
//		    String username="sa";
//		    String password="";
		    Connection conn=JDBCUtils.getConn();
		    Statement stmt=conn.createStatement();
		   
		    int size=0;
		    if(shopCar.getGoodsList()!=null)
		    	size=shopCar.getGoodsList().size();
		    else
		    {
		    	//System.out.println("shopCar.getGoodsList() is null 在DeleteGoods");
		    	return;
		    }
		    	
		    	
		    List<Goods> ShopCarList=shopCar.getGoodsList();
		    
		    String Uno=shopCar.getUno();
		    for(int j=0;j<size;j++)
		    {
		    	Goods goods=ShopCarList.get(j);
		    	stmt.executeUpdate("DELETE FROM ShopCar WHERE Cna='"+goods.getCna()+"' AND Uno='"+Uno+"'");
		    }
		    
			
			stmt.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	


}
