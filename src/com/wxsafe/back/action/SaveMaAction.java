package com.wxsafe.back.action;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.wxsafe.ccy.config.StrConfig;
import com.wxsafe.ccy.dao.DataSourseFactory;
import com.wxsafe.ccy.form.MaterialForm;
import com.wxsafe.ccy.method.CommonMetheds;
import com.wxsafe.ccy.method.MaterialMethods;
import com.wxsafe.ccy.common.Upload;

/**
 * @author : CaoChenYin
 * 
 * @Class : SaveMaAction
 * 
 * @description : 处理保存材料请求
 * 
 * @date : 2009/03/25
 */
public class SaveMaAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		MaterialForm maForm = (MaterialForm) form;
		String flag = "fail";

		if (maForm != null) {
			// 取得操作：添加 &修改
			String operation = maForm.getOperation();
			if (operation != null) {
				String maPicPath = "";
				FormFile pic = maForm.getPic();
				// 当上传图片不为空时，保存图片到本地工程路径
				if (!"".equalsIgnoreCase(pic.getFileName())) {
					// 取得当前工程路径
					String projectPath = this.getServlet().getServletContext()
							.getRealPath("/");
					// 保存图片
					maPicPath = Upload.imageUpload(maForm.getPic(),
							StrConfig.UPLOAD_FILE, null, projectPath);
				}
				String maAffix = "";
				FormFile affix = maForm.getAffix();
				// 当上传附件不为空时，保存附件到本地工程路径
				if (!"".equalsIgnoreCase(affix.getFileName())) {
					// 取得当前工程路径
					String projectPath = this.getServlet().getServletContext()
							.getRealPath("/");
					// 保存附件
					maAffix = Upload.imageUpload(maForm.getAffix(),
							StrConfig.UPLOAD_FILE, null, projectPath);
				}
				Connection conn = null;
				try {
					conn = DataSourseFactory.getDataSource().getConnection();
					MaterialMethods mm = new MaterialMethods(conn);
					int maID = maForm.getMaID();
					// 修改
					if ("update".equalsIgnoreCase(operation)) {
						if (!"".equalsIgnoreCase(maPicPath)) {
							maForm.setMaPicPath(maPicPath);
						}
						if (!"".equalsIgnoreCase(maAffix)) {
							maForm.setMaAffix(maAffix);
						}
						if (mm.upMaterial(maForm)) {
							flag = "success";
						}
					}
					// 添加
					else {
						if ("".equalsIgnoreCase(maPicPath)) {
							maPicPath = StrConfig.UPLOAD_FILE + "nonePic.JPG";
							maForm.setMaPicPath(maPicPath);
						} else {
							maForm.setMaPicPath(maPicPath);
						}
						maForm.setMaAffix(maAffix);
						if (mm.addMaterial(maForm)) {
							CommonMetheds cm = new CommonMetheds(conn);
							maID = cm.getLastInsertID();
							flag = "success";
						}
					}
					conn.close();
					request.setAttribute("forward", "/viewMa.do?maID=" + maID);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return mapping.findForward(flag);
	}
}