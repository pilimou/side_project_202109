package com.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestTest {
	
	@RequestMapping("/")
	public String test() {
		return "Hey, Spring Boot 的 Hello World !";
	}
}
