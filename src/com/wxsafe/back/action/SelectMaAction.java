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
import com.wxsafe.ccy.dto.MaterialDto;
import com.wxsafe.ccy.dto.PageDto;
import com.wxsafe.ccy.form.SelectForm;
import com.wxsafe.ccy.method.MaterialMethods;

/**
 * @author : CaoChenYin
 * 
 * @Class : SelectMaAction
 * 
 * @description : 处理搜索材料请求
 * 
 * @date : 2009/04/01
 */
public class SelectMaAction extends Action {

	// 每页显示信息条数
	int rows = 5;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		SelectForm selectForm = (SelectForm) form;
		String flag = "fail";
		Connection conn = null;
		try {
			conn = DataSourseFactory.getDataSource().getConnection();
			MaterialMethods mm = new MaterialMethods(conn);
			// 获得搜索出来的材料信息的总条数
			int count = mm.getMaterialCount(selectForm.getKeyword());
			int page = 0;
			//获得当前页
			String getPage = request.getParameter("page");
			if (getPage != null) {
				page = Integer.parseInt(getPage);
			}
			PageDto pageDto = new PageDto(count, page);
			//获得当前页的材料list
			List<MaterialDto> list = mm.listMaterialByKey(selectForm
					.getKeyword(), pageDto);
			conn.close();
			if (list.size() == 0) {
				list = null;
			}
			request.setAttribute("ma", list);
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