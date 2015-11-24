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
import com.wxsafe.ccy.method.MaterialMethods;

/**
 * @author : CaoChenYin
 * 
 * @Class : ChangeRecommendAction
 * 
 * @description : 处理viewType.jsp页面修改是否推荐请求
 * 
 * @date : 2009/04/10
 */
public class ChangeRecommendAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// DoForm对象
		DoForm doForm = (DoForm) form;
		// 从session中获得页面上有所有材料的ID数据
		int[] lastIDs = (int[]) request.getSession().getAttribute("lastIDs");
		// 获取推荐材料的ID数据
		int[] isIDs = doForm.getIsIDs();
		// 得到当前页
		int page = doForm.getPage();
		// 获得当前分类
		int typeID = doForm.getTypeID();
		Connection conn = null;
		try {
			// 获得数据库连接
			conn = DataSourseFactory.getDataSource().getConnection();
			// 材料处理逻辑对象
			MaterialMethods mm = new MaterialMethods(conn);
			// 执行修改推荐
			if (mm.changeIsCommend(isIDs, lastIDs)) {
				// 关闭数据库连接
				conn.close();
				// 返回当前页面
				return new ActionForward("/viewType.do?typeID=" + typeID
						+ "&&page=" + page);
			}
			// 关闭数据库连接
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapping.findForward("fail");
	}
}