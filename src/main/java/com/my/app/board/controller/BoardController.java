package com.my.app.board.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/index")
	public void index(HttpServletResponse response) throws IOException {
		response.getWriter().println("Hello World!");
	}

}
