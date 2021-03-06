package service;

import Dao.ArticleinfoDao;
import models.Articleinfo;
import units.ResultJson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class init extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int state = -1;
        String msg = "";
        Articleinfo art = null;
        int id = Integer.parseInt(request.getParameter("id"));
        if (id>0){
            ArticleinfoDao articleinfoDao  = new ArticleinfoDao();
            try {
                art = articleinfoDao.init(id);
                state = 1;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            msg = "文章不存在";
        }
        HashMap<String,Object> map = new HashMap<>();
        map.put("state",state);
        map.put("msg",msg);
        map.put("art",art);
        ResultJson.writeMap(response,map);
    }
}
