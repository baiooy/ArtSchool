package com.wxsafe.ccy.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wxsafe.ccy.dto.UserDto;

public abstract class AdminBase extends Action {

	public final ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// �����l�ж�
		HttpSession session = request.getSession();
		UserDto dto = new UserDto();
		try {
			dto = (UserDto) session.getAttribute("loginAdmin");
			String userName = dto.getUserName();
			// �ж��Ƿ��Ѿ���½
			if (userName.equalsIgnoreCase(null)) {

				return (mapping.findForward("fail"));

			}
		} catch (NullPointerException e) {
			request.setAttribute("error", "");
			return (mapping.findForward("fail"));
		}

		return doexecute(mapping, form, request, response, dto);
	}

	public abstract ActionForward doexecute(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response, UserDto userDto);
}
