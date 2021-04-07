package service;

import Dao.ArticleinfoDao;
import models.Articleinfo;
import models.Userinfo;
import units.ResultJson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class article extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int state = -1;
         String msg = "";
         List<Articleinfo>  list  =null;
        HttpSession  session  =request.getSession(false);
        if (session == null || session.getAttribute("userinfo")==null){
            msg= "登录失败";
            state = 100;
        }else{
            Userinfo userinfo = (Userinfo) session.getAttribute("userinfo");
            int uid = userinfo.getId();
            ArticleinfoDao articleinfoDao = new ArticleinfoDao();
            try {
                list = articleinfoDao.list(uid);
                state = 200;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        HashMap<String,Object> map = new HashMap<>();
        map.put("state",state);
        map.put("msg",msg);
        map.put("list",list);
        ResultJson.writeMap(response,map);
    }
}
