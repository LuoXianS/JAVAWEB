package units;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBunit {
    public static MysqlDataSource dataSource  =  null;
    public static Connection getConnection() throws SQLException {
        if (dataSource == null) {
            dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://127.0.0.1:3306/blog?charactionEncoding=utf-8");
            dataSource.setUser("root");
            dataSource.setPassword("123456");
        }
        return dataSource.getConnection();
    }
    public static void close(Connection connection,
                             PreparedStatement statement,
                             ResultSet resultSet) throws SQLException {
        if (resultSet != null) resultSet.close();
        if (connection != null) connection.close();
        if (statement != null) statement.close();
    }
}
