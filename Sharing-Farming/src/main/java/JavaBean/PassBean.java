package JavaBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.User;
import org.junit.Test;

public class PassBean extends BaseDao{

	public void Pass(String uno) {
		update("update Users set Ust=1 where Uno=?", uno);
	}
	
	public void PassFarming(String Fst,String Lno ) {
		String sql = "jdbc:h2:/Users/coopskywalker/IdeaProjects/Sharing-Farming/GXNZ";
		//String sql = "jdbc:h2:d:/temp/h2/GXNZ3";
		try {
//			Class.forName("org.h2.Driver");
//			//Connection conn = DriverManager.getConnection("jdbc:h2:D:\\h2/GXNZ", "sa", "");
//			Connection conn = DriverManager.getConnection(sql, "sa", "");
			Connection conn = JDBCUtils.getConn();
	        Statement stmt = conn.createStatement();
	        stmt.execute("update Land set Lst=2 where Lno='"+Lno+"'");
			if("托管代种".equals(Fst)) {
				Statement stmt1 = conn.createStatement();
				ResultSet rs=stmt1.executeQuery("select Ano from Admins ");
				while (rs.next()){
					stmt.execute("update Farming set Ano='"+rs.getString(1)+"' where Lno='"+Lno+"'");
				}
			}
	        stmt.close();
	        conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

//	@Test
//	public void test(){
//		String sql = "jdbc:h2:/Users/coopskywalker/IdeaProjects/Sharing-Farming/GXNZ";
//		String Lno="240002",Fst="托管代种";
//		//String sql = "jdbc:h2:d:/temp/h2/GXNZ3";
//		try {
//			Class.forName("org.h2.Driver");
//			//Connection conn = DriverManager.getConnection("jdbc:h2:D:\\h2/GXNZ", "sa", "");
//			Connection conn = DriverManager.getConnection(sql, "sa", "");
//			Statement stmt = conn.createStatement();
//			stmt.execute("update Land set Lst=2 where Lno='"+Lno+"'");
//			if("托管代种".equals(Fst)) {
//				Statement stmt1 = conn.createStatement();
//				ResultSet rs=stmt1.executeQuery("select Ano from Admins ");
//				while (rs.next()){
//					stmt.execute("update Farming set Ano='"+rs.getString(1)+"' where Lno='"+Lno+"'");
//				}
//				System.out.printf("PassFarming!!!");
//			}
//			stmt.close();
//			conn.close();
//		}catch(ClassNotFoundException e) {
//			e.printStackTrace();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//	}

    public void FaidFarming(String Uno,String Lno) {
//        String sql = "jdbc:h2:/Users/coopskywalker/IdeaProjects/Sharing-Farming/GXNZ";
//		try {
//			Class.forName("org.h2.Driver");
//			//Connection conn = DriverManager.getConnection("jdbc:h2:D:\\h2/GXNZ", "sa", "");
//			Connection conn = DriverManager.getConnection(sql, "sa", "");
//	        Statement stmt = conn.createStatement();
//	        stmt.execute("update Land set Lst=0 where Lno='"+Lno+"'");
//	        stmt.execute("delete from Farming where Lno='"+Lno+"'and Uno='"+Uno+"'");
//	        stmt.close();
//	        conn.close();
//		}catch(ClassNotFoundException e) {
//			e.printStackTrace();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
		update("update Land set Lst=0 where Lno=?", Lno);
		update("delete from Farming where Lno=? and Uno=?", Lno, Uno);
	}
}
