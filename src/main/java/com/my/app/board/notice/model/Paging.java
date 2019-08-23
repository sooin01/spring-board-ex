package com.my.app.board.notice.model;

public class Paging {

	int totalPage; // 총 페이지번호
	int nowPage; // 현재 페이지번호
	int startPage; // 현재 블럭의 첫 페이지번호
	int endPage; // 현재 블럭의 마지막 페이지번호
	int firstPage; // 첫 페이지
	int lastPage; // 마지막 페이지
	int prevPage; // 이전 페이지
	int nextPage; // 다음 페이지
	int totalBlock;
	int nowBlock;

	public static void main(String[] args) {
		Paging pageVo = Paging.getPaging(101, 9, 10, 10);
		System.out.println(pageVo.nowBlock + " ~ " + pageVo.totalBlock);
		System.out.println(pageVo.firstPage + " ~ " + pageVo.lastPage);
		System.out.println(pageVo.startPage + " ~ " + pageVo.endPage);
	}

	public static Paging getPaging(int totalCount, int nowPage, int countPerPage, int countPerBlock) {
		int totalPage = ((totalCount - 1) / countPerPage) + 1;

		int totalBlock = (totalPage - 1) / countPerBlock;
		int nowBlock = (nowPage - 1) / countPerBlock;

		int firstPage = nowBlock > 0 ? 1 : 0;
		int lastPage = totalPage;
		int startPage = nowBlock * countPerBlock + 1;
		int endPage = countPerBlock * (nowBlock + 1);
		if (endPage > totalPage)
			endPage = totalPage;
		int prevPage = startPage - 1;
		int nextPage = endPage + 1;

		Paging paging = new Paging();
		paging.setNowPage(nowPage);
		paging.setTotalPage(totalPage);
		paging.setTotalBlock(totalBlock);
		paging.setNowBlock(nowBlock);
		paging.setFirstPage(firstPage);
		paging.setLastPage(lastPage);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setPrevPage(prevPage);
		paging.setNextPage(nextPage);

		return paging;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
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

	public int getTotalBlock() {
		return totalBlock;
	}

	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}

	public int getNowBlock() {
		return nowBlock;
	}

	public void setNowBlock(int nowBlock) {
		this.nowBlock = nowBlock;
	}

}
