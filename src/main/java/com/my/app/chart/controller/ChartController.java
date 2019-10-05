package com.my.app.chart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChartController {

	@RequestMapping(value = "/chart/index")
	public String index() {
		return "chart/index";
	}

}
