package com.wzy.class10;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class AttributeListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {
    private static int count=0;

    // Public constructor is required by servlet spec
    public AttributeListener() {

    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */

    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */

    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        System.out.println("session创建");
        ServletContext context = se.getSession().getServletContext();//得到ServletContext对象
        Integer num = (Integer) context.getAttribute("num");//得到存在ServletContext对象中的num的值
        if(num==null) {//如果为空,说明是第一个访问的用户
            num = 1;
        }else {
            num++;//不为空,num++
        }
        context.setAttribute("num", num);//再把num装到ServletContext域中
        System.out.println("当前网站人数:"+num);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        System.out.println("session销毁");
        ServletContext context = se.getSession().getServletContext();
        Integer num = (Integer) context.getAttribute("num");
        num--;//session，num--
        context.setAttribute("num", num);//再把num装到ServletContext域中,方便页面中得到num信息
        System.out.println("离开了一个人,离开后的人数"+num);
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
      String name=sbe.getName();
      System.out.println("session中添加了一个属性name="+name);
      System.out.println("该属性的值value="+sbe.getSession().getAttribute("username"));
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
