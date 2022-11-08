package com.exe.Mchet.login.service;

import java.util.List;

import com.exe.Mchet.login.domain.LoginVO;
import javax.servlet.http.HttpSession;

public interface LoginService { //interface는 이런 애들을 만들거야~ 하고 예시를 들어주는거?

	List<LoginVO> getLoginList();
	
	LoginVO getContent(LoginVO vo);
	

	void createUser(LoginVO vo);

	void updateUser(LoginVO vo);


	void deleteUser(LoginVO vo);
	
	String loginCheck(LoginVO vo, HttpSession session);// session이 들어가네?
	void logout(HttpSession session);
	
	
	
}

