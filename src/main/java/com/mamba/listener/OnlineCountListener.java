package com.mamba.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author mamba
 * @create 2021-02-23
 */
//统计网站在线人数：统计session
public class OnlineCountListener implements HttpSessionListener {

    @Override
    //创建session的监听：看你的一举一动
    //一旦创建session就会触发一次这个事件。
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(se.getSession().getId());
        ServletContext ctx = se.getSession().getServletContext();
        Integer onlineCount = (Integer)ctx.getAttribute("OnlineCount");
        if(onlineCount == null){
            onlineCount = new Integer(1);
        }else {
            int count = onlineCount.intValue();

            onlineCount = new Integer(count+1);
        }
        ctx.setAttribute("onlineCount",onlineCount);
    }

    @Override
    //销毁session的监听
    //一旦销毁session就会触发一次这个事件。
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();
        se.getSession().invalidate();
        Integer onlineCount = (Integer)ctx.getAttribute("OnlineCount");
        if(onlineCount == null){
            onlineCount = new Integer(1);
        }else {
            int count = onlineCount.intValue();

            onlineCount = new Integer(count-1);
        }
        ctx.setAttribute("onlineCount",onlineCount);
    }

    /*
    session:的销毁
    1.自动销毁：
    2.手动销毁：se.getSession().invalidate();
     */


}
