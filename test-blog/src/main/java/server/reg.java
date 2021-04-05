package server;

import Dao.UserinfoDao;
import models.Userinfo;
import units.ResultJson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class reg extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String msg = "";
        int state = -1;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username == null || password ==null){
            msg = "参数不正确";
        }else{
            //给数据库给值
            Userinfo userinfo = new Userinfo();
            userinfo.setUsername(username);
            userinfo.setPassword(password);
            UserinfoDao userinfoDao = new UserinfoDao();
            try {
                state = userinfoDao.add(userinfo)?200:100;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            HashMap<String,Object> map = new HashMap<>();
            map.put("state",state);
            map.put("msg",msg);
            ResultJson.writeMap(response,map);

        }
    }
}
