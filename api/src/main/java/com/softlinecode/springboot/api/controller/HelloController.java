package com.softlinecode.springboot.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softlinecode.springboot.domain.hello.HelloService;

/**
 * softlinecode@gmail.com
 */
@RestController
public class HelloController {

	@Autowired
	private HelloService helloService;

	@RequestMapping("/hello")
	public String hello() {
		return "hello " + helloService.hello();
	}

}
