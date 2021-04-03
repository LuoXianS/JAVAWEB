import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
@MultipartConfig
public class file exdoGet(request, response);
    }
    protetends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.cted void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        Part part = request.getPart("myFile");
        UUID uuid = UUID.randomUUID();
        part.write("E:\\"+uuid+part.getSubmittedFileName());
        PrintWriter writer = response.getWriter();
        writer.println("上传成功");
    }
}
