/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.wxsafe.ccy.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * MyEclipse Struts Creation date: 04-22-2009
 * 
 * XDoclet definition:
 * 
 * @struts.form name="DetailForm"
 */
public class DetaiForm extends ActionForm {
	/*
	 * Generated Methods
	 */

	private int maID;

	private int isNext;

	private int typeID;
	
	private int page;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getMaID() {
		return maID;
	}

	public void setMaID(int maID) {
		this.maID = maID;
	}

	public int getIsNext() {
		return isNext;
	}

	public void setIsNext(int isNext) {
		this.isNext = isNext;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	/**
	 * Method validate
	 * 
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Method reset
	 * 
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}
}