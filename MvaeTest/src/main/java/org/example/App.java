package org.example;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, SQLException {
        //1.创建数据库
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://127.0.0.1:3306/java?characterEncoding=utf8");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        //获取连接
        Connection connection = dataSource.getConnection();
        //拼接sql
        String sql = "select * from student where id=?";
        PreparedStatement statement =
                connection.prepareStatement(sql);
        statement.setInt(1,2);
        // 4.查询SQL
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("ID:%d,name:%s",
                    resultSet.getInt("id"),
                    resultSet.getString("name"));
        }
    }
}
