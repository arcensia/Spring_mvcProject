package com.exe.Mchet.login.service;

import java.util.List;

import com.exe.Mchet.login.domain.LoginVO;
import javax.servlet.http.HttpSession;

public interface LoginService { //interface�� �̷� �ֵ��� ����ž�~ �ϰ� ���ø� ����ִ°�?

	List<LoginVO> getLoginList();
	
	LoginVO getContent(LoginVO vo);
	

	void createUser(LoginVO vo);

	void updateUser(LoginVO vo);


	void deleteUser(LoginVO vo);
	
	String loginCheck(LoginVO vo, HttpSession session);// session�� ����?
	void logout(HttpSession session);
	
	
	
}

