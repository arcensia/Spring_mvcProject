package com.exe.Mchet.login.service;

import java.util.List;

import com.exe.Mchet.login.domain.LoginVO;

public interface LoginService {
	
	// 글 목록 조회
	List<LoginVO> getLoginList();
	
	// 글 상세 조회
	LoginVO getContent(LoginVO vo);
	
	// 글 등록
	void createUser(LoginVO vo);

	// 글 수정
	void updateUser(LoginVO vo);

	// 글 삭제
	void deleteUser(LoginVO vo);
}
