package JavaBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Farming;

public class ShowFarmingBean extends BaseDao{
	public List<Farming> ShowFarming(){
		return queryForList(Farming.class, "select Lno,Uno,Ano,Pno,Fday,Fst from Farming");
		}

}
