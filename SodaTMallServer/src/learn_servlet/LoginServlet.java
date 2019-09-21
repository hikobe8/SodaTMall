package learn_servlet;

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
        if ("admin".equals(name) && "123".equals(password)) {
            //服务端跳转
//            req.getRequestDispatcher("success.html").forward(req, resp);
            //客户端跳转
            req.getSession().setAttribute("user", "admin");
            resp.sendRedirect("hero");
        } else {
//            req.getRequestDispatcher("failure.html").forward(req, resp);
            resp.sendRedirect("login.html");
        }

    }

}
