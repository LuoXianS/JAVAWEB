package dao;

import models.Userinfo;
import utils.DBUtils;

import java.sql.*;

public class UserinfoDao {

    public static boolean add(Userinfo userinfo) throws SQLException {
        boolean result = false;
        if (userinfo.getUsername()!= null && userinfo.getPassword()!=null){
            Connection connection  = DBUtils.getConnect();
            String sql = "insert into userinfo (username,password) values(?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,userinfo.getUsername());
            statement.setString(2,userinfo.getPassword());
            result = statement.executeUpdate()>=1?true:false;
            DBUtils.close(connection,statement,null);
        }
        return result;
    }
    public static boolean login(Userinfo userinfo) throws SQLException {
        boolean result = false;
        if (userinfo.getUsername() != null && userinfo.getPassword() != null) {
            Connection connection = DBUtils.getConnect();
            String sql = "select * from userinfo where username =? and password =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,userinfo.getUsername());
            statement.setString(2,userinfo.getPassword() );
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return  true;
            }
            DBUtils.close(connection,statement,resultSet);
        }
        return result;
    }
}
