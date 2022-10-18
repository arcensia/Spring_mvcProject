package com.exe.Mchet.login.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exe.Mchet.login.dao.LoginDAO;
import com.exe.Mchet.login.domain.LoginVO;
import com.exe.Mchet.login.service.LoginService;


@Service //service는 DAO가 DB에서 받은 데이터를 가공하는 역할
public class LoginServiceImpl implements LoginService{
	@Autowired//bean을 주입하는 것들. spring been 클래스라 인식함. @Controller, @service, @repository, @component
	private LoginDAO loginDAO;
	
	@Override
	public List<LoginVO> getLoginList() {
		return loginDAO.getLoginList();
	}

	@Override
	public LoginVO getContent(LoginVO vo) {
		return loginDAO.getContent(vo);
	}

	@Override
	public void createUser(LoginVO vo) {
		loginDAO.createUser(vo);
	}

	@Override
	public void updateUser(LoginVO vo) {
		loginDAO.updateUser(vo);
	}

	@Override
	public void deleteUser(LoginVO vo) {
		loginDAO.deleteBoard(vo);
	}
}
