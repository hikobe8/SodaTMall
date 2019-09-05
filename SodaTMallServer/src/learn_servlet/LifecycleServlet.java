package learn_servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author : Ray
 * Created At : 2019-09-02 7:59 PM
 * Email : ryu18356@gmail.com
 * Description : servlet生命周期
 */
public class LifecycleServlet extends HttpServlet {

    /**
     * 只会执行一次，也说明servlet是单例的
     */
    public LifecycleServlet() {
        System.out.println("learn_servlet.LifecycleServlet()");
    }

    /**
     * 初始化方法，只会执行一次
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    /**
     * 在init(ServletConfig config)之后
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        super.init();
    }

    /**
     * 业务方法一般写这里,多次调用，一次请求调用一次
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("service(HttpServletRequest req, HttpServletResponse resp)");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet(HttpServletRequest req, HttpServletResponse resp)");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost(HttpServletRequest req, HttpServletResponse resp)");
    }

    /**
     * 被销毁的时候调用
     */
    @Override
    public void destroy() {
        System.out.println("destroy()");
        super.destroy();
    }
}
