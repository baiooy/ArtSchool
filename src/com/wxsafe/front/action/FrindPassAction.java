
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
import com.wxsafe.ccy.form.UserForm;
import com.wxsafe.ccy.method.UserMethods;

/**
 * @author : CaoChenYin
 * 
 * @Class : FrindPassAction
 * 
 * @description : 处理找回密码请求
 * 
 * @date : 2009/04/27
 */
public class FrindPassAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String flag = "fail";
		UserForm userForm = (UserForm) form;
		Connection conn = null;
		try {
			conn = DataSourseFactory.getDataSource().getConnection();
			UserMethods um = new UserMethods(conn);
			//如果ID存在，则执行判断回答
			if (userForm.getUserID() != 0) {
				UserDto dto = um.selectUserByAnswer(userForm.getUserID(),
						userForm.getUserAnswer());
				conn.close();
				//不存在对应的用户，即回答问题错误时
				if (dto != null) {
					request.setAttribute("error", "<font color=\" black\">"
							+ StrConfig.REMEBER_PASS + "</font>"
							+ dto.getUserPass());
					request.setAttribute("backUrl",
							"/ArtSchool/navigate.do");
				} else {
					request.setAttribute("error", StrConfig.ANSWER_WRONG);
					request.setAttribute("backUrl", userForm.getBackUrl());
				}	
			}
			//如果ID不存在，则根据用户名找到用户，返回找回密码问题
			else {
				UserDto dto = um.selectUserByName(userForm.getUserName());
				conn.close();
				if (dto != null) {
					flag = "success";
					request.setAttribute("user", dto);
				} else {
					request.setAttribute("error", StrConfig.USER_NONE);
					request.setAttribute("backUrl", userForm.getBackUrl());
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapping.findForward(flag);
	}
}