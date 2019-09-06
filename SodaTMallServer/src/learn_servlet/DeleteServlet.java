package learn_servlet;

import learn_servlet.dao.HeroDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author : Ray
 * Created At : 2019-09-06 2:31 PM
 * Email : ryu18356@gmail.com
 * Description :
 */
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new HeroDao().delete(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect("hero");
    }
}
