package com.my.app.board.notice.model;

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

	public static void main(String[] args) {
		Paging pageVo = Paging.getPaging(181, 19, 10, 10);

		System.out.print(pageVo.firstPage + ", ");
		System.out.print(pageVo.prevPage + ", ");
		for (int i = pageVo.startPage; i <= pageVo.endPage; i++) {
			System.out.print("[" + i + "], ");
		}
		System.out.print(pageVo.nextPage + ", ");
		System.out.println(pageVo.lastPage);
	}

	/**
	 * @param totalCount 총 글 수
	 * @param page       페이지 번호
	 * @param listCount  페이지 당 글 수
	 * @param pageCount  한 화면에 나오는 페이지 수
	 * @return Paging
	 */
	public static Paging getPaging(int totalCount, int page, int listCount, int pageCount) {
		int currentBlock = (page - 1) / pageCount;

		int firstPage = currentBlock > 0 ? 1 : 0;
		int startPage = currentBlock * pageCount + 1;
		int lastPage = ((totalCount - 1) / listCount) + 1;
		int endPage = pageCount * (currentBlock + 1);
		int prevPage = startPage - 1;
		int nextPage = endPage + 1;
		if (endPage >= lastPage) {
			nextPage = lastPage;
			endPage = lastPage;
		}

		Paging paging = new Paging();
		paging.setPage(page);
		paging.setFirstPage(firstPage);
		paging.setLastPage(lastPage);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setPrevPage(prevPage);
		paging.setNextPage(nextPage);

		return paging;
	}

}
