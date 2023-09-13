package JavaBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.User;

public class RegistrationApplicationBean extends BaseDao{
	public List<User> ShowInformation() {
		return queryForList(User.class, "select * from Users where Ust=0");
	}
}
