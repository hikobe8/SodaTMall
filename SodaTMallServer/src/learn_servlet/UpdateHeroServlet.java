package learn_servlet;

import learn_servlet.bean.HeroBean;
import learn_servlet.dao.HeroDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author : Ray
 * Created At : 2019-09-06 5:37 PM
 * Email : ryu18356@gmail.com
 * Description :
 */
public class UpdateHeroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            float hp = Float.parseFloat(req.getParameter("hp"));
            int damage = Integer.parseInt(req.getParameter("damage"));
            HeroBean heroBean = new HeroBean();
            heroBean.id = id;
            heroBean.name = name;
            heroBean.hp = hp;
            heroBean.damage = damage;
            new HeroDao().update(heroBean);
            resp.sendRedirect("hero");
        } catch (NumberFormatException e) {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println("英雄的血量和伤害值必须为数字!\n" + e.toString());
        }
    }
}
