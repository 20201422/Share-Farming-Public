package JavaBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteGoodsBean extends BaseDao{
	public void DeleteLand(String Cna) {
		update("delete from Goods where Cna=?", Cna);
	}
}
