package com.sid.tutorials.spring.module05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class IndexController {

	// curl -X GET localhost:8080/question06/actionA
	@GetMapping("/actionA")
	@ResponseBody
	public String actionA() {
		return "Handled with @GetMapping(\"/actionA\")\n";
	}

	// curl -X GET localhost:8080/question06/actionB
	@RequestMapping(method = GET, path = "/actionB")
	@ResponseBody
	public String actionB() {
		return "Handled with @RequestMapping(method = RequestMethod.GET, path = \"/actionB\")\n";
	}

	// curl -X GET localhost:8080/question06/actionC
	// curl -X POST localhost:8080/question06/actionC
	// curl -X PATCH localhost:8080/question06/actionC
	@RequestMapping(path = "/actionC")
	@ResponseBody
	public String actionC() {
		return "Handled with @RequestMapping(path = \"/actionC\")\n";
	}

	// curl -X GET localhost:8080/question06/actionD
	// curl -X POST localhost:8080/question06/actionD
	@RequestMapping(path = "/actionD", method = { GET, POST })
	@ResponseBody
	public String actionD() {
		return "Handled with @RequestMapping(path = \"/actionD\", method = {GET, POST})\n";
	}
}
