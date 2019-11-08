package learn_servlet.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session 增加属性 ");
        System.out.println("属性是" + httpSessionBindingEvent.getName());
        System.out.println("值是" + httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session 移除属性 " + httpSessionBindingEvent.getName());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session 替换属性 " + httpSessionBindingEvent.getName());
    }
}
