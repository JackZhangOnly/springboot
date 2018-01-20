package com.jackzhang.huntinghouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HuntinghousesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HuntinghousesApplication.class, args);
	}
	@GetMapping("/hello")
	public String hello(){
		return "Hello,Jack";
	}
}
