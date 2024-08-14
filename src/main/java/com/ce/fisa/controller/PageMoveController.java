package com.ce.fisa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageMoveController {

	@GetMapping("home")
	public String home() {
		return "main";
	}

	@GetMapping("write")
	public String write() {
		return "write";
	}

	@GetMapping("list")
	public String list() {
		return "list";
	}

	@GetMapping("detail")
	public String detail() {
		return "detail";
	}

	@GetMapping("partner")
	public String partner() {
		return "partner";
	}
	
	@GetMapping("partnerdetail")
	public String partnerdetail() {
		return "partnerdetail";
	}
}
