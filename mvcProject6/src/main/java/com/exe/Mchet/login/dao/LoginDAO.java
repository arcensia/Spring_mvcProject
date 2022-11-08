package com.exe.Mchet.login.dao;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exe.Mchet.board.domain.BoardVO;
import com.exe.Mchet.login.domain.LoginVO;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;


//Service에 있는 놈을 이렇게 mybatis에 작동시킬거야! -> mapper에서 DB의 정보를 가져옴. 가져오는 수단은 "Session"  -> Service
@Repository 
public class LoginDAO {
	@Autowired

	@Inject
	private SqlSessionTemplate mybatis;

	public void createUser(LoginVO vo) {
		mybatis.insert("LoginMapper.createUser", vo);//insert
		System.out.println("===> Mybatis createUser() ");
	}

	public void updateUser(LoginVO vo) {
		mybatis.update("LoginMapper.updateUser", vo);
		System.out.println("===> Mybatis updateUser()");
	}

	public void deleteUser(LoginVO vo) {
		System.out.println("===> Mybatis deleteUser() ");
		mybatis.delete("LoginMapper.deleteUser", vo);
	}
	
	public String loginCheck(LoginVO vo) {// mapper에서 전달받는 형태에 따라 public String or list<VO> 로 달라져.
		System.out.println("===> Mybatis loginCheck()");
		return mybatis.selectOne("LoginMapper.loginCheck",vo);
	}
	
	public LoginVO getContent(LoginVO vo) {
		System.out.println("===> Mybatis get content");
		return (LoginVO) mybatis.selectOne("LoginMapper.getContent", vo);
	}

	
}
