package Dao;

import models.Userinfo;
import units.DBunit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserinfoDao {
    public  boolean add(Userinfo userinfo) throws SQLException {
        boolean result = false;
        if (userinfo.getPassword() != null && userinfo.getUsername() != null){
            Connection connection = DBunit.getConnection();
            String sql  = "insert into userinfo(username,password) value(?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,userinfo.getUsername());
            statement.setString(2,userinfo.getPassword());
            result = statement.executeUpdate()>=1?true:false;
            DBunit.close(connection,statement,null);
        }
        return result;
    }
    public boolean login(Userinfo userinfo) throws SQLException {
        boolean result = false;
        if (userinfo.getPassword() != null && userinfo.getUsername() != null) {
            Connection connection = DBunit.getConnection();
            String sql = "select * from userinfo where username =? and password =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,userinfo.getUsername());
            statement.setString(2,userinfo.getPassword());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return true;
            }
            DBunit.close(connection,statement,resultSet);
        }
        return result;
    }
    public Userinfo getUserInfo(Userinfo userinfo) throws SQLException {
        Userinfo user = new Userinfo();
        if (userinfo.getPassword() != null && userinfo.getUsername() != null) {
            Connection connection = DBunit.getConnection();
            String sql = "select * from userinfo where username =? and password =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,userinfo.getUsername());
            statement.setString(2,userinfo.getPassword());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
            }
            DBunit.close(connection,statement,resultSet);
        }
        return user;
    }
}
