package com.zhangyiming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author Administrator
 */
@SpringBootApplication
/**
 * 扫描 mybatis mapper 包路径
 */
@MapperScan(basePackages = "com.zhangyiming.mapper")
@EnableCaching
public class ZhangyimingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZhangyimingApplication.class, args);
	}

}