package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.HomeMapper;
import com.example.demo.vo.UserPrincipalVO;
import com.example.demo.vo.UserVO;

@Service
public class HomeService implements UserDetailsService{

	@Autowired
	private HomeMapper homeMapper;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	/* DB에서 유저정보를 불러온다.
	 * Custom한 Userdetails 클래스를 리턴 해주면 된다.
	 * */
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		
		ArrayList<UserVO> userAuthes = homeMapper.findByUserId(id);
		
		if(userAuthes.size() == 0) {
			throw new UsernameNotFoundException("User "+id+" Not Found!");
		}
		
		return new UserPrincipalVO(userAuthes);
	}
	
	/* 회원 저장
	 * 롤백 설정
	 * */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	public String InsertUser(UserVO userVO) {
		
		userVO.setPassword(bCryptPasswordEncoder.encode(userVO.getPassword()));
		int flag = homeMapper.userSave(userVO);		
		if (flag > 0) {

			int userNo = homeMapper.findUserNo(userVO.getId());
			int roleNo = homeMapper.findRoleNo(userVO.getRoleName());

			homeMapper.userRoleSave(userNo, roleNo);

			return "success";
		}	 	
		return "fail";
	}

}
