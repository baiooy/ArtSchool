package com.wxsafe.back.action;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wxsafe.ccy.config.StrConfig;
import com.wxsafe.ccy.dao.DataSourseFactory;
import com.wxsafe.ccy.dto.UserDto;
import com.wxsafe.ccy.form.LoginForm;
import com.wxsafe.ccy.method.UserMethods;

/**
 * @author : CaoChenYin
 * 
 * @Class : BackLoginAction
 * 
 * @description : 处理backLogin.jsp页面用户登陆请求
 * 
 * @date : 2009/04/10
 */

public class BackLoginAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// LoginForm对象
		LoginForm loginForm = (LoginForm) form;
		//页面跳转参数
		String flag = "fail";
		Connection conn = null;
		try {
			// 获得数据库连接
			conn = DataSourseFactory.getDataSource().getConnection();
			// 用户处理逻辑对象
			UserMethods um = new UserMethods(conn);
			// 根据页面传入的用户名,密码或许用户信息保存为dto对象
			UserDto dto = um.adminLogin(loginForm.getUserName() 
					                   ,loginForm.getUserPass());
			
			// 用户存在时,将dto对象保存在session中传回页面,登陆成功
			if (dto != null) {
				request.getSession().setAttribute("loginAdmin", dto);
				flag = "success";
			}
			// 用户不存在时,登陆失败
			else {
				request.setAttribute("error", StrConfig.LOGIN_FAIL);
			}
			
			//关闭数据库连接
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 上页地址
		request.setAttribute("backUrl", loginForm.getLoginUrl());
		return mapping.findForward(flag);
	}
}