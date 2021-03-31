import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class getck extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        Cookie[] cookies = request.getCookies();
        PrintWriter writer = response.getWriter();
        for (Cookie cookie:cookies) {
            writer.println(String.format("cookieName:%s <p></P> cookieValue:%s",cookie.getName(),cookie.getValue()));
        }





    }
}
