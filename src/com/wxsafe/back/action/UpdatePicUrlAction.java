
package com.wxsafe.back.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wxsafe.ccy.common.FileDelete;
import com.wxsafe.ccy.common.Upload;
import com.wxsafe.ccy.config.GetConfig;
import com.wxsafe.ccy.config.StrConfig;
import com.wxsafe.ccy.form.ConfigForm;

/**
 * @author : CaoChenYin
 * 
 * @Class : UpdatePicUrlAction
 * 
 * @description : 处理前台广告分类图片请求
 * 
 * @date : 2009/04/25
 */
public class UpdatePicUrlAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ConfigForm picUrlForm = (ConfigForm) form;
		//获得图片key
		String picKey = picUrlForm.getPicKey();
		//获得广告外连地址key
		String urlKey = picUrlForm.getUrlKey();
		String backurl = picUrlForm.getBackurl();
		String projectPath = this.getServlet().getServletContext().getRealPath(
				"/");
		try {
			//前台配置文件对象
			GetConfig gc = new GetConfig(projectPath);
            //修改图片地址，及上传新的图片
			if (picKey != null
					&& (!"".equalsIgnoreCase(picUrlForm.getPic().getFileName()))) {
				String filePath = projectPath + gc.getPorperty(picKey);
				FileDelete.delelteFile(filePath);
				String newPicValue = Upload.imageUpload(picUrlForm.getPic(),
						StrConfig.ADVER_SORT, picKey, projectPath);
				gc.updateConfig(picKey, newPicValue);
			}
			//修改广告外连地址
			if (urlKey != null
					&& (!"".equalsIgnoreCase(picUrlForm.getUrlValue()))) {

				gc.updateConfig(urlKey, picUrlForm.getUrlValue());	
			}
			return new ActionForward(backurl);
		} catch (Exception e) {
		}
		String flag = "fail";
		return mapping.findForward(flag);
	}
}