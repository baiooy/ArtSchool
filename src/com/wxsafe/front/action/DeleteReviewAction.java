package com.wxsafe.front.action;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wxsafe.ccy.dao.DataSourseFactory;
import com.wxsafe.ccy.form.ReviewForm;
import com.wxsafe.ccy.method.ReviewMetheds;

/**
 * @author : CaoChenYin
 * 
 * @Class : DeleteReviewAction
 * 
 * @description : 处理显示删除评论请求
 * 
 * @date : 2009/04/29
 */
public class DeleteReviewAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ReviewForm reviewForm = (ReviewForm) form;
		// 获取评论ID
		int reID = reviewForm.getReID();
		Connection conn = null;
		try {
			conn = DataSourseFactory.getDataSource().getConnection();
			ReviewMetheds rm = new ReviewMetheds(conn);
			// 删除评论
			if (rm.deleteReByID(reID)) {
				return new ActionForward(reviewForm.getBackUrl());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mapping.findForward("fail");
	}
}