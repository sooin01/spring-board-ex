package com.my.app.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.app.board.model.Board;
import com.my.app.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "/board")
	public String index() {
		return "board/index";
	}

	@RequestMapping(value = "/board/list")
	@ResponseBody
	public List<Board> list(Board board, ModelMap model) {
		return boardService.getBoardList(board);
	}

}
