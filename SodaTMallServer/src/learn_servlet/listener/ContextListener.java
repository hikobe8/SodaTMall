package learn_servlet.listener;

import javax.servlet.ServletContextEvent;

public class ContextListener implements javax.servlet.ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Web应用初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Web应用销毁");
    }
}
