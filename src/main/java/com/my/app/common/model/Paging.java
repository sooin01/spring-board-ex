package com.my.app.common.model;

public class Paging {

	int page; // 현재 페이지번호
	int startPage; // 현재 블럭의 첫 페이지번호
	int endPage; // 현재 블럭의 마지막 페이지번호
	int firstPage; // 첫 페이지번호
	int lastPage; // 마지막 페이지번호
	int prevPage; // 이전 페이지번호
	int nextPage; // 다음 페이지번호

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

}
