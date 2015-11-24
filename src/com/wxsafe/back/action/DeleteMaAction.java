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
import com.wxsafe.ccy.method.ReviewMetheds;

/**
 * @author : CaoChenYin
 * 
 * @Class : DeleteMaAction
 * 
 * @description : 处理删除材料请求
 * 
 * @date : 2009/03/25
 */
public class DeleteMaAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		DoForm doForm = (DoForm) form;// TODO Auto-generated method stub
		String flag = "fail";
		// 取得要删除的材料ID数组
		int[] maIDs = doForm.getMaIDs();
		Connection conn = null;
		try {
			conn = DataSourseFactory.getDataSource().getConnection();
			MaterialMethods mm = new MaterialMethods(conn);
            //删除材料
			if (mm.deleteMaterial(maIDs)) {
				ReviewMetheds rm = new ReviewMetheds(conn);
				//删除材料的相关评论
				rm.deleteReByMa(maIDs);
				conn.close();
				int page = doForm.getPage();
				int typeID = doForm.getTypeID();
				String forwardUrl = "";
				//判断执行后跳转的页面
				if (0 >= typeID) {
					forwardUrl = "/selectMa.do?keyword=" + doForm.getKeyword()
							+ "&&page=" + page;
				} else {
					forwardUrl = "/viewType.do?typeID=" + typeID + "&&page="
							+ page;
				}
				return new ActionForward(forwardUrl);
				// }
			} else {
				request.setAttribute("error", "delete fail");
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapping.findForward(flag);

	}
}