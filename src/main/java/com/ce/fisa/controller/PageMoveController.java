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
		return "/write";
	}
	
}
