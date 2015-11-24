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
import com.wxsafe.ccy.method.TypeMethods;

/**
 * @author : CaoChenYin
 * 
 * @Class : DeleteTypeAction
 * 
 * @description : 处理删除分类请求
 * 
 * @date : 2009/03/31
 */
public class DeleteTypeAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String flag = "fail";
		//取得要删除的分类ID
		String getID = request.getParameter("typeID");
		//取得要删除的分类的父分类ID
		String getParent = request.getParameter("typeParent");
		//判断ID是否为null,为null则不执行
		if ((getID != null) && (getParent != null)) {
			int typeID = Integer.parseInt(getID);
			int typeParent = Integer.parseInt(getParent);
			Connection conn = null;
			try {
				conn = DataSourseFactory.getDataSource().getConnection();
				TypeMethods tm = new TypeMethods(conn);
				//删除分类
				if (tm.deleteType(typeID)) {
					conn.close();
					return new ActionForward("/viewType.do?typeID="
							+ typeParent);
				}
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return mapping.findForward(flag);
	}
}