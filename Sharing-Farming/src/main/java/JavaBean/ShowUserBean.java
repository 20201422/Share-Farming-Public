package JavaBean;

import Model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ShowUserBean extends BaseDao{
	public List<User> ShowInformation(){
		return queryForList(User.class, "select Uno,Una,Uemil,Ust from Users where Ust=1");
	}
}
