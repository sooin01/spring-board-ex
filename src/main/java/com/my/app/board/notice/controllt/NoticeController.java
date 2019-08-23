package com.my.app.board.notice.controllt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.my.app.board.notice.model.FileBucket;
import com.my.app.board.notice.service.NoticeService;

@Controller
@RequestMapping(value = "/notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@GetMapping(value = { "/", "/list" })
	public String list() {
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
	public String save(@RequestParam(value = "id", required = false) Integer id) {
		return "redirect:/notice/view?id=" + id;
	}

	@PostMapping(value = "/upload")
	public void upload(FileBucket fileBucket) {
		System.out.println(fileBucket.getFile().getOriginalFilename());
		System.out.println(fileBucket.getFile().getSize());
	}

}
