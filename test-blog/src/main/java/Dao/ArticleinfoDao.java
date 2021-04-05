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
        return list;
    }

}
