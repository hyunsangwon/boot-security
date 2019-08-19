package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.HomeService;
import com.example.demo.vo.UserVO;

@RestController
public class UserRestController {

	@Autowired
	private HomeService homeService;
	
	@PostMapping("/user/save")
	public String saveUserInfo(@RequestBody UserVO userVO) {
		
		return homeService.InsertUser(userVO);
	}
	
}
