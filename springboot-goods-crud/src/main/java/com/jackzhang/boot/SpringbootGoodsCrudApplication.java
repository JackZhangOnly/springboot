package com.jackzhang.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jackzhang.boot.mapper")
public class SpringbootGoodsCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootGoodsCrudApplication.class, args);
	}
}
