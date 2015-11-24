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
import com.wxsafe.ccy.form.UserForm;
import com.wxsafe.ccy.method.UserMethods;

/**
 * @author : CaoChenYin
 * 
 * @Class : RegistAction
 * 
 * @description : 处理注册用户请求
 * 
 * @date : 2009/04/24
 */
public class RegistAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		UserForm userForm = (UserForm) form;
		String flag = "fail";
		Connection conn = null;
		try {
			conn = DataSourseFactory.getDataSource().getConnection();
			UserMethods um = new UserMethods(conn);
			int userID = userForm.getUserID();
			// 用户ID为0时，执行添加用户
			if (userID == 0) {
				if (um.addUser(userForm)) {
					flag = "success";
					request.setAttribute("message", StrConfig.REGIST);
					request.setAttribute("userName", userForm.getUserName());
					request.setAttribute("userPass", userForm.getUserPass());
				}
			}
			// 用户ID不为0时，执行修改用户
			else {
				if (um.updateUser(userForm)) {
					flag = "success";
					request.setAttribute("message", StrConfig.UPDATE);
					request.setAttribute("userName", userForm.getUserName());
					request.setAttribute("userPass", userForm.getUserPass());
				}
			}

			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapping.findForward(flag);
	}
}