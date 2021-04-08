package service;

import Dao.ArticleinfoDao;
import units.ResultJson;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet("/upCount")
public class upCount extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         int succ = -1;
         String msg= "";
        int id = Integer.parseInt(req.getParameter("id"));
        if (id>0){
            ArticleinfoDao articleinfoDao = new ArticleinfoDao();
            try {
                succ = articleinfoDao.upcount(id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            msg = "参数有误";
        }
        HashMap<String,Object> map = new HashMap<>();
        map.put("succ",succ);
        map.put("msg",msg);
        ResultJson.writeMap(resp,map);
    }
}
