package service;

import Dao.ArticleinfoDao;
import models.vo.ArticleinfoVo;
import units.ResultJson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/list")
public class list extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int succ = -1;
       String msg  ="";
       List<ArticleinfoVo> list  = null;
       int cpage = Integer.parseInt(req.getParameter("cpage"));
       int psize  = Integer.parseInt(req.getParameter("psize"));
        ArticleinfoDao dao = new ArticleinfoDao();
        try {
            list = dao.getlistByPage(cpage,psize);
            succ = 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        HashMap<String,Object> map = new HashMap<>();
        map.put("succ",succ);
        map.put("msg",msg);
        map.put("list",list);
        ResultJson.writeMap(resp,map);
    }
}
