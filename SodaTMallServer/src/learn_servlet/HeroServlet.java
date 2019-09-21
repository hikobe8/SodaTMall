package learn_servlet;

import learn_servlet.bean.HeroBean;
import learn_servlet.dao.HeroDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author : Ray
 * Created At : 2019-09-05 11:07 PM
 * Email : ryu18356@gmail.com
 * Description :
 */
public class HeroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("login.html");
            return;
        }

        int start = 0;
        int count = 5;
        try {
            start = Integer.parseInt(req.getParameter("start"));
        } catch (Exception ignored) {

        }
        HeroDao heroDao = new HeroDao();
        List<HeroBean> list = heroDao.list(start, 5);
        int total = heroDao.getCount();
        int last = 0;
        if (total % count == 0) {
            last = total - count;
        } else {
            last = total - total % count;
        }
        int next = start + count;
        next = next > last ? last : next;
        int pre = start - count;
        pre = pre < 0 ? 0 : pre;
        req.setAttribute("pre", pre);
        req.setAttribute("next", next);
        req.setAttribute("last", last);
        req.setAttribute("heros", list);
        req.getRequestDispatcher("heroList.jsp").forward(req, resp);
    }
}
