package com.my.app.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

	@RequestMapping(value = "/board")
	public String index() {
		return "board/index";
	}

	@RequestMapping(value = "/board/list")
	public String list() {
		return "board/list";
	}

}
