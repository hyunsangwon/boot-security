package com.example.demo.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.UserVO;

@Repository
public interface HomeMapper {

	ArrayList<UserVO> findByUserId(@Param("id") String id);
	
	int userSave(UserVO userVO);
	
	int userRoleSave(@Param("userNo") int userNo,@Param("roleNo") int roleNo);
	
	int findUserNo(@Param("id") String id);
	int findRoleNo(@Param("roleName") String roleName);
}
