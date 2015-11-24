package com.wxsafe.front.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wxsafe.ccy.config.StrConfig;
import com.wxsafe.ccy.dao.DataSourseFactory;
import com.wxsafe.ccy.dto.MaterialDto;
import com.wxsafe.ccy.dto.PageDto;
import com.wxsafe.ccy.dto.TypeDto;
import com.wxsafe.ccy.form.SortLevelForm;
import com.wxsafe.ccy.method.MaterialMethods;
import com.wxsafe.ccy.method.TypeMethods;

/**
 * @author : CaoChenYin
 * 
 * @Class : SortLevelAction
 * 
 * @description : 处理前sortlevel_middle.jsp页面
 * 
 * @date : 2009/04/20
 */
public class SortLevelAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		SortLevelForm sortLevelForm = (SortLevelForm) form;
		String flag = "fail";

		Connection conn = null;
		try {
			conn = DataSourseFactory.getDataSource().getConnection();
			// 分类ID
			int typeID = sortLevelForm.getTypeID();
			// 当前页
			int page = sortLevelForm.getPage();
			// 关键字
			String keyword = sortLevelForm.getKeyword();
			if (keyword == null) {
				keyword = "";
			}
			int count = 0;
			int pages = 0;
			List<MaterialDto> list = new ArrayList<MaterialDto>();
			MaterialMethods mm = new MaterialMethods(conn);
			// 取的当前状态下材料总条数
			count = mm.getMaterialCount(typeID, keyword);
			PageDto dto = new PageDto(count, page, 16);
			// 取的当前状态下材料list
			list = mm.listMaterialByKeyType(typeID, keyword, dto);
			pages = dto.getPages();
			request.setAttribute("maList", list);
			request.setAttribute("page", page);
			request.setAttribute("pages", pages);
			request.setAttribute("count", count);
			request.setAttribute("keyword", keyword);
			// 基础分类ID
			if (typeID < 13) {
				request.getSession().setAttribute("navigateID", typeID);
			}
			TypeDto typeDto = new TypeDto();
			// 全部图库
			if (typeID == 0) {
				typeDto.setTypeID(typeID);
				typeDto.setTypeName(StrConfig.ALL_SORT);
			}
			// 十二项基础分类
			else {
				TypeMethods tm = new TypeMethods(conn);
				typeDto = tm.selectType(typeID);
			}
			request.setAttribute("type", typeDto);
			// 当前分类下的下载排行榜
			List<MaterialDto> topDown = mm.selectTopDown(typeID);
			request.setAttribute("topDown", topDown);
			TypeMethods tm = new TypeMethods(conn);
			// 取得所有子分类
			List<TypeDto> childType = tm.selectChildType(typeID);
			request.setAttribute("childType", childType);
			// 取得所有父分类
			List<TypeDto> allType = tm.selectAllParentType(typeID);
			request.setAttribute("allType", allType);
			conn.close();
			flag = "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapping.findForward(flag);
	}
}