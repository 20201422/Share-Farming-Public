package JavaBean;

import Model.Admin;
import Model.User;
import org.junit.Test;

import java.sql.*;

public class LoginAndRegistBean extends BaseDao{

    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from users where uno=? and upwd=?";
        return queryForOne(User.class, sql, username,password);
    }


    public boolean existsUsername(String username) {
        String sql = "select * from users where uno=?";
        if (queryForOne(User.class, sql, username) == null)
            return false;
        return true;
    }

    public void saveUser(User user) {
        String sql = "insert into Users values(?,?,?,?,?)";
        update(sql, user.getUno(), user.getUna(), user.getUpwd(), user.getUemil(), user.getUst());
    }

    public Admin queryAdminByUsernameAndPassword(String username, String password) {
        String sql = "select * from admins where ano=? and apwd=?";
        return queryForOne(Admin.class, sql, username,password);
    }

    public User queryUserByEmail(String email) {
        String sql = "select * from users where uemil=?";
        return queryForOne(User.class, sql, email);
    }

    public void modifyPasswordByUsername(String username, String password) {
        update("update users set upwd=? where uno=?", password, username);
    }

//    @Test
//    public void test() {
//        String sql = "select * from admins where ano=? and apwd=?";
//        System.out.println(queryForOne(Admin.class, sql, "gly","123456"));
//    }

    public void deleteUserByUno(String uno) {
        update("delete from Farming where Uno=?", uno);//删除数据在耕种表
        update("delete from Users where Uno=?", uno);//删除数据在用户表
    }
}
