package JavaBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Land;

public class DeleteTillBean extends BaseDao{
	public int JudgeLand(String Lno) {
		int lst=-1;
		try {
//			Class.forName("org.h2.Driver");//.newInstance();
//			Connection conn = DriverManager.getConnection("jdbc:h2:D:\\h2/GXNZ", "sa", "");
//			//Connection conn = DriverManager.getConnection("jdbc:h2:/Users/coopskywalker/IdeaProjects/GXNZ/GXNZ", "sa", "");
			Connection conn = JDBCUtils.getConn();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select Lst from Land where Lno='"+Lno+"'");
			while (rs.next()) {//循环土地表
				lst= Integer.parseInt(rs.getString(1));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}
	public void DeleteLand(String Lno) {
		update("delete from Land wehre Lno=?", Lno);
	}
}
