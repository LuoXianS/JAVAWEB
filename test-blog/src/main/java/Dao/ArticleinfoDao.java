package Dao;

import models.Articleinfo;
import units.DBunit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleinfoDao {
    public List<Articleinfo> list(int uid) throws SQLException {
        List<Articleinfo> list = new ArrayList<>();
        Connection connection = DBunit.getConnection();
        String sql = "select * from articleinfo where user_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,uid);
        ResultSet resultSet =  statement.executeQuery();
        while(resultSet.next()){
            Articleinfo articleinfo = new Articleinfo();
            articleinfo.setId(resultSet.getInt("id"));
            articleinfo.setContent(resultSet.getString("content"));
            articleinfo.setTitle(resultSet.getString("title"));
            articleinfo.setCreate_time(resultSet.getTime("create_time"));
            articleinfo.setUpdate_time(resultSet.getTime("update_time"));
            articleinfo.setRcount(resultSet.getInt("rcount"));
            list.add(articleinfo);
        }
        DBunit.close(connection,statement,resultSet);
        return list;
    }
    public int mydel(int id) throws SQLException {
        int result = 0;
        Connection connection = DBunit.getConnection();
        String sql = "delete from articleinfo where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        result = statement.executeUpdate();
        DBunit.close(connection,statement,null);
        return result;
    }
    public int addart(String title,String content,int user_id) throws SQLException {
        int result = 0;
        Connection connection = DBunit.getConnection();
        String sql = "insert into articleinfo (title,content,user_id) values(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,title);
        statement.setString(2,content);
        statement.setInt(3,user_id);
        result = statement.executeUpdate();
        DBunit.close(connection,statement,null);
        return result;
    }
    public int update(String title ,String content ,int id) throws SQLException {
        int result = 0;
        Connection connection =DBunit.getConnection();
        String sql = "update articleinfo set title =?,content =? where  id =?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,title);
        statement.setString(2,content);
        statement.setInt(3,id);
        result = statement.executeUpdate();
        DBunit.close(connection,statement,null);
        return result;
    }

    public Articleinfo init(int id) throws SQLException {
        Articleinfo articleinfo = new Articleinfo();
        Connection connection = DBunit.getConnection();
        String sql = "select * from articleinfo where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()){
            articleinfo.setTitle(resultSet.getString("title"));
            articleinfo.setContent(resultSet.getString("content"));
        }
        DBunit.close(connection,statement,resultSet);
        return articleinfo;
    }
}
