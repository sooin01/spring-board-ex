package com.my.app.common.util;

import com.my.app.board.notice.model.Paging;

public class PagingUtil {

	/**
	 * @param totalCount 총 글 수
	 * @param page       페이지 번호
	 * @param listCount  페이지 당 글 수
	 * @param pageCount  한 화면에 나오는 페이지 수
	 * @return Paging
	 */
	public static Paging getPaging(int totalCount, int page, int listCount) {
		int pageCount = 10;
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

	public static void main(String[] args) {
		Paging pageVo = PagingUtil.getPaging(181, 19, 10);

		System.out.print(pageVo.getFirstPage() + ", ");
		System.out.print(pageVo.getPrevPage() + ", ");
		for (int i = pageVo.getStartPage(); i <= pageVo.getEndPage(); i++) {
			System.out.print("[" + i + "], ");
		}
		System.out.print(pageVo.getNextPage() + ", ");
		System.out.println(pageVo.getLastPage());
	}

}
