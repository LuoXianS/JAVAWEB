package service;

import dao.UserinfoDao;
import models.Userinfo;
import utils.ResultJson;

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username == null && password == null) {
            msg = "参数不正确";
        } else {
            Userinfo userinfo = new Userinfo();
            userinfo.setUsername(username);
            userinfo.setPassword(password);
            UserinfoDao userinfoDao = new UserinfoDao();
            try {
                state = userinfoDao.login(userinfo) ? 200 : 100;
                HttpSession session = request.getSession();
                session.setAttribute("userinfo",userinfo);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        HashMap<String,Object>  result = new HashMap<>();
        result.put("state",state);
        result.put("msg",msg);
        ResultJson.writeMap(response,result);
    }
}
