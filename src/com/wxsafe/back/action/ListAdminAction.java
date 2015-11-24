
package com.wxsafe.back.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wxsafe.ccy.dao.DataSourseFactory;
import com.wxsafe.ccy.dto.UserDto;
import com.wxsafe.ccy.method.UserMethods;

/**
 * @author : CaoChenYin
 * 
 * @Class : ListAdminAction
 * 
 * @description : 处理遍历管理员请求
 * 
 * @date : 2009/04/10
 */
public class ListAdminAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String flag = "fail";

		Connection conn = null;
		try {
			conn = DataSourseFactory.getDataSource().getConnection();
			UserMethods um = new UserMethods(conn);
			//取得管理员list
			List<UserDto> list = um.listAdmin();
			conn.close();
			request.setAttribute("admin", list);
			flag = "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapping.findForward(flag);
	}
}