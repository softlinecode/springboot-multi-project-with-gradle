package com.softlinecode.springboot.domain.hello;

import org.springframework.stereotype.Service;

/**
 * @author softlinecode@gmail.com
 */
@Service
public class HelloService {

	public String hello() {
		return "thanks";
	}
}
