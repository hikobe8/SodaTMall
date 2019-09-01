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
        System.out.println("用户名: " + name);
        System.out.println("密  码: " + password);
        resp.getWriter().println("<h1>用户名:"+ name +"<br/> 密码:"+ password +"</h1>");
    }

}
