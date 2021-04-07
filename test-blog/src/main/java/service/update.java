package service;

import Dao.ArticleinfoDao;
import units.ResultJson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class update extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String msg = "";
        int succ = 0;
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        if (title != null && content != null && !title.equals("")&& !content.equals("")){
            HttpSession session = request.getSession(false);
            if (session!= null && session.getAttribute("userinfo")!=null){
                ArticleinfoDao articleinfoDao = new ArticleinfoDao();
                try {
                    succ = articleinfoDao.update(title,content,id);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }else{
                msg  ="非法登录,登录异常";
            }
        }else{
             msg = "修改失败,请重新再试";
        }
        HashMap<String,Object> map = new HashMap<>();
        map.put("succ",succ);
        map.put("msg",msg);
        ResultJson.writeMap(response,map);
    }

}
