package com.wxsafe.ccy.dto;

public class ReviewDto {

	private int reID;

	private String reMessage;

	private int maID;

	private int userID;

	private String reTime;

	private int rowNum;

	private String userCall;

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public String getUserCall() {
		return userCall;
	}

	public void setUserCall(String userCall) {
		this.userCall = userCall;
	}

	public int getReID() {
		return reID;
	}

	public void setReID(int reID) {
		this.reID = reID;
	}

	public String getReMessage() {
		return reMessage;
	}

	public void setReMessage(String reMessage) {
		this.reMessage = reMessage;
	}

	public int getMaID() {
		return maID;
	}

	public void setMaID(int maID) {
		this.maID = maID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getReTime() {
		return reTime;
	}

	public void setReTime(String reTime) {
		this.reTime = reTime;
	}

}
