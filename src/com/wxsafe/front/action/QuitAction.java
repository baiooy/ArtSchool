
package com.wxsafe.front.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author : CaoChenYin
 * 
 * @Class : QuitAction
 * 
 * @description : 处理用户退出请求
 * 
 * @date : 2009/04/20
 */
public class QuitAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String backUrl = request.getParameter("backUrl");
		//清空session中的用户信息
		request.getSession().setAttribute("user", null);
		return new ActionForward(backUrl);
	}
}