package com.example.demo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVO {

	private int userNo; //회원 pk
	private String id; //회원 아이디
	private String password;// 비밀번호
	private String name; // 회원 이름
	
	private String roleName; //권한 이름
	
}
