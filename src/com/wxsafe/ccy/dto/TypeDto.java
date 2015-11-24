package com.wxsafe.ccy.dto;

public class TypeDto {

	private int typeID;
	private String typeName;
	private int typeParent;
	private String parentName;
	private int rowNum;

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getTypeParent() {
		return typeParent;
	}

	public void setTypeParent(int typeParent) {
		this.typeParent = typeParent;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

}
