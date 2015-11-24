package com.wxsafe.front.action;

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
 * @Class : LoginAction
 * 
 * @description : 处理前台用户登陆请求
 * 
 * @date : 2009/04/20
 */
public class LoginAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		LoginForm loginForm = (LoginForm) form;

		Connection conn = null;
		try {
			conn = DataSourseFactory.getDataSource().getConnection();
			UserMethods um = new UserMethods(conn);
			// 取得用户信息
			UserDto dto = um.userLogin(loginForm);
			conn.close();
			// 用户存在的话，则将信息存入session
			if (dto != null) {
				request.getSession().setAttribute("user", dto);
				return new ActionForward(loginForm.getLoginUrl());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("error", StrConfig.LOGIN_FAIL);
		request.setAttribute("backUrl", request.getContextPath()
				+ loginForm.getLoginUrl());
		return mapping.findForward("fail");
	}
}