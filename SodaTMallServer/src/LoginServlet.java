import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author : Ray
 * Created At : 2019-09-01 11:22 PM
 * Email : ryu18356@gmail.com
 * Description :
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        StringBuilder responseBuilder = new StringBuilder();
        if ("admin".equals(name) && "123".equals(password)) {
            responseBuilder.append("<h1 style='color:green'>").append(name).append(", 你好").append("</h1>");
        } else {
            responseBuilder.append("<h1 style='color:red'>").append("用户名或密码错误!").append("</h1>");
        }
        resp.getWriter().println(responseBuilder.toString());
    }

}
