package JavaBean;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 其他Dao继承的抽象类
 */
public abstract class BaseDao {

    private QueryRunner queryRunner = new QueryRunner();
    /**
     * update() 方法用来执行：Insert\Update\Delete 语句
     *
     * @return 如果返回-1,说明执行失败<br/>返回其他表示影响的行数
     */
    public int update(String sql, Object... args) {
        Connection connection = JDBCUtils.getConn();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close(); // 关闭连接，资源资源
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 查询返回一个 javaBean 的 sql 语句
     *
     * @param type 返回的对象类型
     * @param sql 执行的 sql 语句
     * @param args sql 对应的参数值
     * @param <T> 返回的类型的泛型
     * @return
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection con = JDBCUtils.getConn();
        try {
            return queryRunner.query(con, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                con.close(); // 关闭连接，资源资源
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 查询返回多个 javaBean 的 sql 语句
     *
     * @param type 返回的对象类型
     * @param sql 执行的 sql 语句
     * @param args sql 对应的参数值
     * @param <T> 返回的类型的泛型
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection con = JDBCUtils.getConn();
        try {
            return queryRunner.query(con, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                con.close(); // 关闭连接，资源资源
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 执行返回一行一列的 sql 语句
     * @param sql 执行的 sql 语句
     * @param args sql 对应的参数值
     * @return
     */
    public Object queryForSingleValue(String sql, Object... args) {
        Connection conn = JDBCUtils.getConn();
        try {
            return queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close(); // 关闭连接，资源资源
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
