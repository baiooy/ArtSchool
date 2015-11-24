
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
import com.wxsafe.ccy.dto.UserDto;
import com.wxsafe.ccy.method.UserMethods;

/**
 * @author : CaoChenYin
 * 
 * @Class : ViewTypeAction
 * 
 * @description : 处理显示用户信息请求
 * 
 * @date : 2009/04/13
 */
public class ViewUserAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String flag = "fail";
		Connection conn = null;
		//获取用户ID
		String getID = request.getParameter("userID");
		if (getID != null) {
			int userID = Integer.parseInt(getID);
			try {
				conn = DataSourseFactory.getDataSource().getConnection();
				UserMethods um = new UserMethods(conn);
				//获取用户信息保存在dto中
				UserDto dto = um.selectUserByID(userID);
				conn.close();

				request.setAttribute("user", dto);
				flag = "success";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return mapping.findForward(flag);
	}
}