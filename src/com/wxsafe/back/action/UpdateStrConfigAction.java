
package com.wxsafe.back.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wxsafe.ccy.config.GetConfig;
import com.wxsafe.ccy.form.ConfigForm;
/**
 * @author : CaoChenYin
 * 
 * @Class : UpdateStrConfigAction
 * 
 * @description : 处理前台配置请求
 * 
 * @date : 2009/05/04
 */
public class UpdateStrConfigAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ConfigForm configForm = (ConfigForm) form;
		String projectPath = this.getServlet().getServletContext().getRealPath(
				"/");
		GetConfig gc = new GetConfig(projectPath);
		if (configForm.getStrKey() != null
				&& (!"".equalsIgnoreCase(configForm.getStrValue()))) {

			gc.updateConfig(configForm.getStrKey(), configForm.getStrValue());
		}
		return new ActionForward(configForm.getBackurl());
	}
}