package com.chungfung;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DruidDataSourceAutoConfigure.class})
@MapperScan("com.chungfung.mapper")
public class SpringBootDatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDatasourceApplication.class, args);
	}

}
