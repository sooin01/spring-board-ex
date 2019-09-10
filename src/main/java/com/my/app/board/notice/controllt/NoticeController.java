package com.my.app.board.notice.controllt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.app.board.model.Board;
import com.my.app.board.service.BoardService;
import com.my.app.common.annotation.Authorization;
import com.my.app.common.annotation.Authorization.Role;
import com.my.app.common.model.Paging;
import com.my.app.common.util.PagingUtil;

@Controller
@RequestMapping(value = "/notice")
public class NoticeController {

	@Autowired
	private BoardService boardService;

	@Authorization(name = { Role.ADMIN, Role.USER })
	@GetMapping(value = { "/", "/list" })
	public String list(Board board, Model model) {
		board.setOffset((board.getPage() - 1) * board.getListCount());
		int noticeCount = boardService.getBoardCount(board);
		List<Board> noticeList = boardService.getBoardList(board);
		model.addAttribute("noticeList", noticeList);

		Paging paging = PagingUtil.getPaging(noticeCount, board.getPage(), board.getListCount());
		model.addAttribute("paging", paging);

		return "notice/list";
	}

	@GetMapping(value = { "/view" })
	public String view() {
		return "notice/view";
	}

	@GetMapping(value = { "/form" })
	public String write() {
		return "notice/form";
	}

	@PostMapping(value = { "/save" })
	@ResponseBody
	public void save(Board board) {
		board.setUserId("admin");
		board.setIsDelete(false);
		boardService.insertBoard(board);
	}

}
