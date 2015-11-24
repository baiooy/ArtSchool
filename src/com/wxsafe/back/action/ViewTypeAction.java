package com.wxsafe.back.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
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
import com.wxsafe.ccy.dto.TypeDto;
import com.wxsafe.ccy.method.MaterialMethods;
import com.wxsafe.ccy.method.TypeMethods;

/**
 * @author : CaoChenYin
 * 
 * @Class : ViewTypeAction
 * 
 * @description : 处理显示分类及下属材料信息请求
 * 
 * @date : 2009/03/24
 */
public class ViewTypeAction extends Action {

	int rows = 5;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String flag = "fail";
		// 取得要显示的分类ID
		String getID = request.getParameter("typeID");
		if (getID != null) {
			Connection conn = null;
			try {
				conn = DataSourseFactory.getDataSource().getConnection();
				TypeMethods tm = new TypeMethods(conn);
				int typeID = Integer.parseInt(getID);
				// 却得分类信息保存在dto中
				TypeDto dto = tm.selectType(typeID);
				request.setAttribute("type", dto);
				MaterialMethods mm = new MaterialMethods(conn);
				// 取得当前分类下所有材料的数量
				int count = mm.getMaterialCount(typeID);
				// 获取当前页
				int page = 0;
				String getPage = request.getParameter("page");
				if (getPage != null) {
					page = Integer.parseInt(getPage);
				}
				PageDto pageDto = new PageDto(count, page);
				// 获取当前页下材料的list
				List<MaterialDto> list = mm
						.listMaterialsByType(typeID, pageDto);
				if (list.size() == 0) {
					list = null;
				} else {
					//将当前页所有ID保存在数组中，已备修改推荐时使用
					int[] maIDs = new int[list.size()];
					Iterator<MaterialDto> ir = list.iterator();
					int i = 0;
					while (ir.hasNext()) {
						maIDs[i] = ((MaterialDto) ir.next()).getMaID();
						i++;
					}
					//将数组传到session中
					request.getSession().setAttribute("lastIDs", maIDs);
				}
				request.setAttribute("ma", list);
				request.setAttribute("page", page);
				request.setAttribute("pages", pageDto.getPages());
				request.setAttribute("count", count);
				conn.close();
				flag = "success";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return mapping.findForward(flag);
	}
}