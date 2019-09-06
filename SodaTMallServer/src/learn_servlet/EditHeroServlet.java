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
 * Created At : 2019-09-06 5:49 PM
 * Email : ryu18356@gmail.com
 * Description :
 */
public class EditHeroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        HeroBean heroBean = new HeroDao().get(id);
        StringBuilder stringBuilder = new StringBuilder();
        if (heroBean != null) {
            stringBuilder.append("<form action='updateHero' method='post'>");
            stringBuilder.append(String.format("<input type='hidden' name='id' value=%d />", heroBean.id));
            stringBuilder.append(String.format("名称: <input name='name' type='text' value='%s'/> <br/>", heroBean.name));
            stringBuilder.append(String.format("血量: <input name='hp' type='text' value='%f'/> <br/>", heroBean.hp));
            stringBuilder.append(String.format("名称: <input name='damage' type='text' value='%d'/> <br/>", heroBean.damage));
            stringBuilder.append("<button type='submit'>更新</button>");
            stringBuilder.append("</form>");
        } else {
            stringBuilder.append("用户数据为空!");
        }
        resp.getWriter().println(stringBuilder.toString());
    }
}
