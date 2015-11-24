/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.wxsafe.back.action;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wxsafe.ccy.dao.DataSourseFactory;
import com.wxsafe.ccy.form.AdminForm;
import com.wxsafe.ccy.method.UserMethods;

/**
 * @author : CaoChenYin
 * 
 * @Class : SelectUserAction
 * 
 * @description : 处理修改管理员请求
 * 
 * @date : 2009/04/19
 */
public class UpdateAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		AdminForm adminForm = (AdminForm) form;// TODO Auto-generated method
		// stub
		String flag = "fail";
		Connection conn = null;

		try {
			conn = DataSourseFactory.getDataSource().getConnection();
			UserMethods um = new UserMethods(conn);
			//修改权限
			if (adminForm.getUserRole() != 0) {
				if (um.changeRole(adminForm)) {
					flag = "success";
				}
			} 
			//修改除权限的其他信息
			else {
				if (um.updateAdmin(adminForm)) {
					flag = "success";
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