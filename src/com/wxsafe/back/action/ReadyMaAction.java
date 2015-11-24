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
import com.wxsafe.ccy.dto.TypeDto;
import com.wxsafe.ccy.method.MaterialMethods;
import com.wxsafe.ccy.method.TypeMethods;

/**
 * @author : CaoChenYin
 * 
 * @Class : ReadyMaAction
 * 
 * @description : 处理材料的预操作请求
 * 
 * @date : 2009/03/24
 */
public class ReadyMaAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String flag = "fail";
		// 取得操作
		String operation = request.getParameter("operation");
		if (operation != null) {
			Connection conn = null;
			try {
				conn = DataSourseFactory.getDataSource().getConnection();
				String getID = null;
				MaterialMethods mm = new MaterialMethods(conn);
				MaterialDto dto = new MaterialDto();
				// 准备修改
				if ("update".equalsIgnoreCase(operation)) {
					getID = request.getParameter("maID");
					int maID = 0;
					if (getID == null) {
						getID = request.getSession().getAttribute("maID")
								.toString();
					}
					maID = Integer.parseInt(getID);
					dto = mm.selectMaterial(maID);
					request.getSession().setAttribute("maID", maID);
					flag = "ready";

				}
				// 准备复制
				else if ("copy".equalsIgnoreCase(operation)) {
					getID = request.getParameter("maID");
					int maID = 0;
					if (getID == null) {
						getID = request.getSession().getAttribute("maID")
								.toString();
					}
					maID = Integer.parseInt(getID);
					dto = mm.selectMaterial(maID);
					dto.setMaCode("");
					dto.setMaName("");
					dto.setMaPicPath("");
					dto.setMaAffix("");
					flag = "ready";
				}
				// 准备添加
				else if ("add".equalsIgnoreCase(operation)) {
					int typeID = Integer.parseInt(request
							.getParameter("typeID"));
					TypeMethods tm = new TypeMethods(conn);
					TypeDto _dto = tm.selectType(typeID);
					dto.setMaType(_dto.getTypeID());
					dto.setTypeName(_dto.getTypeName());

				}
				request.setAttribute("operation", operation);
				request.setAttribute("ma", dto);

				flag = "ready";
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return mapping.findForward(flag);
	}
}