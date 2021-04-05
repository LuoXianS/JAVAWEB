package server;

import Dao.ArticleinfoDao;
import units.ResultJson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class del extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int succ = 0;
        String msg = "";
        //接收前段的要删除的ID
        int id = Integer.parseInt(request.getParameter("id"));
        if ( id >= 1){
            ArticleinfoDao articleinfoDao = new ArticleinfoDao();
            try {
                //调用数据库执行删除操作
                int res = articleinfoDao.mydel(id);
                if (res >0){
                    succ = 1;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            msg = "删除失败";
        }
        HashMap<String,Object> map = new HashMap<>();
        map.put("succ",succ);
        map.put("msg",msg);
        ResultJson.writeMap(response,map);
    }
}
