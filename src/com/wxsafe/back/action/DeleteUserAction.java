
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
import com.wxsafe.ccy.form.DoForm;
import com.wxsafe.ccy.method.UserMethods;

/**
 * @author : CaoChenYin
 * 
 * @Class : DeleteUserAction
 * 
 * @description : 处理删除注册用户请求
 * 
 * @date : 2009/04/13
 */
public class DeleteUserAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		DoForm doForm = (DoForm) form;
		String flag = "fail";
		// 取得要删除的用户的ID数组
		int[] userIDs = doForm.getUserIDs();
		Connection conn = null;
		try {
			conn = DataSourseFactory.getDataSource().getConnection();
			UserMethods um = new UserMethods(conn);
			//删除用户
			if (um.deleteUser(userIDs)) {
				conn.close();
				if (1 == doForm.getDeleteModel()) {
					request.setAttribute("error", "deleteError");
				} else {
					return new ActionForward("/selectUser.do?keyword="
							+ doForm.getKeyword() + "&&page="
							+ doForm.getPage());
				}
			} else {
				request.setAttribute("error", "deleteError");
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapping.findForward(flag);

	}
}