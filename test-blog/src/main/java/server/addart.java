package server;

import Dao.ArticleinfoDao;
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

public class addart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //接收前端信息
        int succ = 0;
        String msg = "";
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        //操作数据库
        if (content != null &&title!=null){
            HttpSession session = request.getSession(false);
            if (session!= null && session.getAttribute("userinfo")!=null
                &&!session.equals("")&&!session.getAttribute("userinfo").equals("")){
                Userinfo userinfo = (Userinfo)session.getAttribute("userinfo");
                ArticleinfoDao articleinfoDao = new ArticleinfoDao();
                try {
                    succ=articleinfoDao.addart(title,content,userinfo.getId());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }else{
                msg = "不合法登录";
            }
        }else{
            msg = "操作失败,参数出错";
        }
        HashMap<String,Object> map = new HashMap<>();
        map.put("succ",succ);
        map.put("msg",msg);
        ResultJson.writeMap(response,map);
    }

}
