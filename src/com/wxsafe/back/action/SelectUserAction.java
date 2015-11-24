
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
import com.wxsafe.ccy.dto.PageDto;
import com.wxsafe.ccy.dto.UserDto;
import com.wxsafe.ccy.form.SelectForm;
import com.wxsafe.ccy.method.UserMethods;

/**
 * @author : CaoChenYin
 * 
 * @Class : SelectUserAction
 * 
 * @description : 处理搜索用户请求
 * 
 * @date : 2009/04/12
 */
public class SelectUserAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		SelectForm selectForm = (SelectForm) form;// TODO Auto-generated method stub
		String flag = "fail";
		Connection conn = null;
		try {
			conn = DataSourseFactory.getDataSource().getConnection();
			UserMethods mm = new UserMethods(conn);
			// 获得搜索出来的用户信息的总条数
			int count = mm.getUserCount(selectForm.getKeyword());
			int page = 0;
			//获得当前页
			String getPage = request.getParameter("page");
			if (getPage != null) {
				page = Integer.parseInt(getPage);
			}
			PageDto pageDto = new PageDto(count, page);
			//获得当前页的用户list
			List<UserDto> list = mm.listUser(selectForm.getKeyword(),pageDto);
			conn.close();
			if (list.size() == 0) {
				list = null;
			}
			request.setAttribute("user", list);
			request.setAttribute("page", page);
			request.setAttribute("pages", pageDto.getPages());
			request.setAttribute("count", count);
			request.setAttribute("keyword", selectForm.getKeyword());
			flag = "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapping.findForward(flag);
	}
}