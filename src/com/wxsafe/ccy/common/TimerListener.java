package com.wxsafe.ccy.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Timer;

/**
 * 
 * @author : Xu Lijian
 * 
 * @class : TimerListener
 * 
 * @description : ���ö�ʱ��
 * 
 * @date : 2006/09/16
 * 
 */

public class TimerListener implements ServletContextListener {

	private Timer timer = null;

	/**
	 * 
	 * @method : contextInitialized
	 * 
	 * @author : Xu Lijian
	 * 
	 * @description : ʵ��javax.servlet.ServletContextListener�ӿڵķ�����
	 *              ��Servlet������ʱ��ִ��
	 * 
	 * @param : ServletContextEvent event(��Ҫ����ĳ���)
	 * 
	 * @date : 2006/09/16
	 * 
	 */
	public void contextInitialized(ServletContextEvent event) {

		timer = new Timer(true);

		timer.schedule(new FileDeleteTask(event.getServletContext()
				.getRealPath("/")), 10000, 60 * 60 * 1000);

		// event.getServletContext().log("�Ѿ���������ȱ�");

	}

	public void contextDestroyed(ServletContextEvent event) {

		timer.cancel();

		// event.getServletContext().log("��ʱ�����");

	}

}
