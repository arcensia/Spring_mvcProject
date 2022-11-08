package com.exe.Mchet.login.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exe.Mchet.login.dao.LoginDAO;
import com.exe.Mchet.login.domain.LoginVO;//=DTO
import com.exe.Mchet.login.service.LoginService;



import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;


// Service에서 뭘 만들지 목차들 봤었지? 자세하게 어떤 행동을 할거야? ex)뭘 return해서 줄거야? vo에 뭘 저장시켜둘거야?
@Service //service -> DAO
public class LoginServiceImpl implements LoginService{
	@Autowired//bean주입시 필요. spring been. @Controller, @service, @repository, @component
	
	@Inject
	private LoginDAO loginDAO;
	
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
		loginDAO.deleteUser(vo);
	}
	
	
	@Override
	public String loginCheck(LoginVO vo, HttpSession session) {
		String name = loginDAO.loginCheck(vo);
		 if (name != null) { // 세션 변수 저장
		  session.setAttribute("userid", vo.getId());
		  session.setAttribute("name", name);
		}
		 return name; 
	}
	
	@Override
	public void logout(HttpSession session) {
		session.invalidate(); // 세션 초기화
	 }
	
	
	
// return을 해줄게 없기 때문	
	@Override
	public List<LoginVO> getLoginList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoginVO getContent(LoginVO vo) {
		// TODO Auto-generated method stub
		return null;
	}


//	@Override
//	public LoginVO getContent(LoginVO vo) {
//		return loginDAO.getContent(vo);
//	}
	
}
