package com.my.app.board.notice.model;

public class Paging {

	int totalPage; // 총 페이지번호
	int page; // 현재 페이지번호
	int startPage; // 현재 블럭의 첫 페이지번호
	int endPage; // 현재 블럭의 마지막 페이지번호
	int firstPage; // 첫 페이지번호
	int lastPage; // 마지막 페이지번호
	int prevPage; // 이전 페이지번호
	int nextPage; // 다음 페이지번호

	public static void main(String[] args) {
		Paging pageVo = Paging.getPaging(200, 20, 10, 10);

		System.out.print(pageVo.firstPage + ", ");
		System.out.print(pageVo.prevPage + ", ");
		for (int i = pageVo.startPage; i <= pageVo.endPage; i++) {
			System.out.print("[" + i + "], ");
		}
		System.out.print(pageVo.nextPage + ", ");
		System.out.println(pageVo.lastPage);
	}

	public static Paging getPaging(int totalCount, int page, int listCount, int pageCount) {
		int totalPage = ((totalCount - 1) / listCount) + 1;

		int currentBlock = (page - 1) / pageCount;

		int firstPage = currentBlock > 0 ? 1 : 0;
		int lastPage = totalPage;
		int startPage = currentBlock * pageCount + 1;
		int endPage = pageCount * (currentBlock + 1);
		if (endPage > totalPage)
			endPage = totalPage;
		int prevPage = startPage - 1;
		int nextPage = (endPage == lastPage) ? endPage : endPage + 1;

		Paging paging = new Paging();
		paging.setPage(page);
		paging.setTotalPage(totalPage);
		paging.setFirstPage(firstPage);
		paging.setLastPage(lastPage);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setPrevPage(prevPage);
		paging.setNextPage(nextPage);

		return paging;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

}
