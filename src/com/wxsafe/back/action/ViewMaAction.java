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
import com.wxsafe.ccy.dto.MaterialDto;
import com.wxsafe.ccy.method.MaterialMethods;

/**
 * @author : CaoChenYin
 * 
 * @Class : ViewMaAction
 * 
 * @description : 处理显示材料信息请求
 * 
 * @date : 2009/03/24
 */
public class ViewMaAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String flag = "fail";
		Connection conn = null;
		// 获取要显示的材料ID
		String getID = request.getParameter("maID");
		if (getID != null) {
			int maID = Integer.parseInt(getID);
			try {
				conn = DataSourseFactory.getDataSource().getConnection();
				MaterialMethods mm = new MaterialMethods(conn);
				// 取得材料信心保存在dto中
				MaterialDto dto = mm.selectMaterial(maID);
				conn.close();

				request.setAttribute("ma", dto);
				flag = "success";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return mapping.findForward(flag);
	}
}