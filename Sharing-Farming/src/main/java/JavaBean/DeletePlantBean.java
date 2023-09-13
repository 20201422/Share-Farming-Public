package JavaBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeletePlantBean extends BaseDao{
	public void DeletePlant(String Pno) {
		update("delete from Plant where Pno=?", Pno);
	}
}
