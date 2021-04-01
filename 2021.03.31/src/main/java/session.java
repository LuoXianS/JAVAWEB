import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class session extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       response.setCharacterEncoding("utf-8");
       response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        //先从客户端获取一个session
        HttpSession session = request.getSession();
        //获取sessionID
        String sessionId = session.getId();
        writer.println("<h1>欢迎访问</h1>");
        writer.println(String.format("<h3>sessionID:%s</h3>",sessionId));
        writer.println("<hr>");
        writer.println(String.format("<h3>session的创建时间:%s</h3><p></p>",new Date(session.getCreationTime())));
        writer.println(String.format("<h3>最后访问时间:%s</h3><p></p>",new Date(session.getLastAccessedTime())));
        String sessionKey  = "countKey";
        if(session.isNew()||session.getAttribute(sessionKey)==null){
            session.setAttribute(sessionKey,1);
            writer.println("<h3>访问次数: 1</h3>");
        }else{
            int count = (int)session.getAttribute(sessionKey);
            count++;
            session.setAttribute(sessionKey,count);
            writer.println("访问次数:"+count);
        }




    }
}
