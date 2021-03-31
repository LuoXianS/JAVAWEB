import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

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
        writer.println("<h>欢迎访问</h>");






    }
}
