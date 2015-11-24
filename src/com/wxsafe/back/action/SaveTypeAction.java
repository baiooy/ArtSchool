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
import com.wxsafe.ccy.form.TypeForm;
import com.wxsafe.ccy.method.TypeMethods;

/**
 * @author : CaoChenYin
 * 
 * @Class : SaveTypeAction
 * 
 * @description : 处理保存分类请求
 * 
 * @date : 2009/04/01
 */
public class SaveTypeAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		TypeForm typeForm = (TypeForm) form;// TODO Auto-generated method stub
		String flag = "fail";
		Connection conn = null;
		try {
			conn = DataSourseFactory.getDataSource().getConnection();
			TypeMethods tm = new TypeMethods(conn);
			// 取得要操作的分类ID
			int typeID = typeForm.getTypeID();
			// ID为0时，则执行添加分类
			if (typeID == 0) {
				if (tm.addType(typeForm)) {
					typeID = typeForm.getTypeParent();
				}
			}
			// ID不为0时，则执行修改分类
			else {
				tm.updateType(typeForm);
			}
			return new ActionForward("/viewType.do?typeID=" + typeID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapping.findForward(flag);
	}
}