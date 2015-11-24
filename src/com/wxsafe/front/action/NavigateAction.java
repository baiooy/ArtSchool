package com.wxsafe.front.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wxsafe.ccy.config.GetConfig;
import com.wxsafe.ccy.dao.DataSourseFactory;
import com.wxsafe.ccy.dto.MaterialDto;
import com.wxsafe.ccy.dto.PageDto;
import com.wxsafe.ccy.dto.TypeDto;
import com.wxsafe.ccy.form.NavigateForm;
import com.wxsafe.ccy.method.MaterialMethods;
import com.wxsafe.ccy.method.TypeMethods;

/**
 * @author : CaoChenYin
 * 
 * @Class : NavigateAction
 * 
 * @description : 处理前navigate_middle.jsp页面
 * 
 * @date : 2009/04/15
 */
public class NavigateAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String flag = "fail";
		NavigateForm navigateForm = (NavigateForm) form;
		// 基础分类ID
		int navigateID = navigateForm.getNavigateID();
		// 获得当前推荐页面
		int page = navigateForm.getPage();
		Connection conn = null;
		try {
			conn = DataSourseFactory.getDataSource().getConnection();
			MaterialMethods mm = new MaterialMethods(conn);
			int count = mm.selectRecommendCount(navigateID);
			PageDto pageDto = new PageDto(count, page, 18);
			// 取得当前页面推荐材料list
			List<MaterialDto> recommend = mm.selectRecommend(navigateID,
					pageDto);
			// 取得下载排行榜list
			List<MaterialDto> topdown = mm.selectTopDown();
			TypeMethods tm = new TypeMethods(conn);
			for (int i = 1; i <= 12; i++) {
				List<TypeDto> typeList = tm.selectChildType(i, 0, 9);
				request.setAttribute("type" + i, typeList);
			}
			conn.close();

			request.setAttribute("recommend", recommend);
			request.getSession().setAttribute("navigateID", navigateID);
			request.setAttribute("page", page);
			request.setAttribute("pages", pageDto.getPages());
			request.setAttribute("count", count);

			request.setAttribute("topdown", topdown);

			// 广告分类图片地址读取
			String projectPath = this.getServlet().getServletContext()
					.getRealPath("/");
			GetConfig gc = new GetConfig(projectPath);
			// 分类图片地址读取
			gc.getSortPicUrlConfig();
			// 获取底部广告,邮箱
			gc.getBottomConfig();
			// 获取头部logo
			gc.getTopConfig();
			// 广告地址
			request.getSession().setAttribute("big_adver_1", gc.big_adver_1);
			request.getSession().setAttribute("big_adver_2", gc.big_adver_2);
			request.getSession().setAttribute("big_adver_3", gc.big_adver_3);
			request.getSession().setAttribute("big_adver_4", gc.big_adver_4);
			request.getSession()
					.setAttribute("small_adver_1", gc.small_adver_1);
			request.getSession()
					.setAttribute("small_adver_2", gc.small_adver_2);
			request.getSession()
					.setAttribute("small_adver_3", gc.small_adver_3);
			request.getSession()
					.setAttribute("small_adver_4", gc.small_adver_4);
			request.getSession()
					.setAttribute("small_adver_5", gc.small_adver_5);
			request.getSession()
					.setAttribute("small_adver_6", gc.small_adver_6);
			request.getSession()
					.setAttribute("small_adver_7", gc.small_adver_7);
			request.getSession()
					.setAttribute("small_adver_8", gc.small_adver_8);
			// 广告图片
			request.getSession().setAttribute("big_pic_1", gc.big_pic_1);
			request.getSession().setAttribute("big_pic_2", gc.big_pic_2);
			request.getSession().setAttribute("big_pic_3", gc.big_pic_3);
			request.getSession().setAttribute("big_pic_4", gc.big_pic_4);
			request.getSession().setAttribute("small_pic_1", gc.small_pic_1);
			request.getSession().setAttribute("small_pic_2", gc.small_pic_2);
			request.getSession().setAttribute("small_pic_3", gc.small_pic_3);
			request.getSession().setAttribute("small_pic_4", gc.small_pic_4);
			request.getSession().setAttribute("small_pic_5", gc.small_pic_5);
			request.getSession().setAttribute("small_pic_6", gc.small_pic_6);
			request.getSession().setAttribute("small_pic_7", gc.small_pic_7);
			request.getSession().setAttribute("small_pic_8", gc.small_pic_8);
			// 分类图片
			request.setAttribute("wood", gc.wood);
			request.setAttribute("stone", gc.stone);
			request.setAttribute("ceramics", gc.ceramics);
			request.setAttribute("glass", gc.glass);
			request.setAttribute("plastic", gc.plastic);
			request.setAttribute("carpet", gc.carpet);
			request.setAttribute("paint", gc.paint);
			request.setAttribute("wallpaper", gc.wallpaper);
			request.setAttribute("metal", gc.metal);
			request.setAttribute("gypsum", gc.gypsum);
			request.setAttribute("hydropower", gc.hydropower);
			request.setAttribute("other", gc.other);
			// email
			request.getSession().setAttribute("email", gc.email);
			// logo
			request.getSession().setAttribute("logo", gc.logo);
			flag = "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mapping.findForward(flag);
	}
}