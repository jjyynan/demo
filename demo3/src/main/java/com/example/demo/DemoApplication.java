package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.UserEntity;

import junit.framework.Test;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
@RequestMapping("/demo")
public class DemoApplication {

	@RequestMapping("/test")
	String test() {
		return "hello SpringBoot";
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@RequestMapping(value="/{abc5}",method=RequestMethod.GET)
	@ResponseBody
	public String addUser(@PathVariable("abc5") Long id) {
		RestTemplate restTemplate=new RestTemplate();
		String url="http://192.168.3.85:8081/user/";
		UserEntity userEntity=new UserEntity();
		userEntity.setId(id);
		userEntity.setUserName("中国MAN");
		userEntity.setPassword("1111");
		userEntity.setUserSex("MAN");
		userEntity.setNickName("熊");
		String result=restTemplate.postForObject(url, userEntity, String.class);
		System.out.println(result);
		return result;
	}

}
