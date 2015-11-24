package com.wxsafe.ccy.dto;

public class PageDto {

	private int rows = 5;

	private int page;

	private int pages;

	private int count;

	private int start;

	public PageDto(int count, int page) {
		this.count = count;
		this.page = page;
		if (count % rows == 0) {
			this.pages = count / rows;
		} else {
			this.pages = count / rows + 1;
		}
		this.start = page * rows;
	}

	public PageDto(int count, int page, int row) {
		this.count = count;
		this.page = page;
		this.rows = row;
		if (count % rows == 0) {
			this.pages = count / rows;
		} else {
			this.pages = count / rows + 1;
		}
		this.start = page * rows;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

}
