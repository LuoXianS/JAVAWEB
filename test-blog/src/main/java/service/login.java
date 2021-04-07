package service;

import Dao.UserinfoDao;
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

public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String msg = "";
        int state = -1;
        String username  = request.getParameter("username");
        String password  = request.getParameter("password");
        if (username != null && password != null ){
            Userinfo userinfo = new Userinfo();
            userinfo.setUsername(username);
            userinfo.setPassword(password);
            UserinfoDao userinfoDao = new UserinfoDao();
            try {
                userinfo = userinfoDao.getUserInfo(userinfo);
                if (userinfo.getId()>0){
                    HttpSession session = request.getSession();
                    session.setAttribute("userinfo",userinfo);
                    state = 200;
                }
                //state =  userinfoDao.login(userinfo)?200:100;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else {
            msg = "参数错误";
        }
        HashMap<String,Object> map = new HashMap<>();
        map.put("state",state);
        map.put("msg",msg);
        ResultJson.writeMap(response,map);
    }
}
