package learn_servlet;

import learn_servlet.bean.HeroBean;
import learn_servlet.dao.HeroDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        resp.setContentType("text/html;charset=utf-8");
        List<HeroBean> list = new HeroDao().list();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<table align='center' border='1' cellspacing='0'>");
        stringBuilder.append("<tr><td>id</td><td>英雄名称</td><td>血量</td><td>伤害值</td></tr>");
        for (HeroBean heroBean : list) {
            String tr = "<tr><td>%d</td><td>%s</td><td>%f</td><td>%d</td></tr>";
            String format = String.format(tr, heroBean.id, heroBean.name, heroBean.hp, heroBean.damage);
            stringBuilder.append(format);
        }
        stringBuilder.append("</table>");
        resp.getWriter().println(stringBuilder.toString());
    }
}
