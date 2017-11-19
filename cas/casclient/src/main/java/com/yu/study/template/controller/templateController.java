package com.yu.study.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/template")
public class templateController {
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String get(){
		return "hello world xxxxxxx";
	}
}
