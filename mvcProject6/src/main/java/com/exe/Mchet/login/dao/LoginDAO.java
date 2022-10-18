package com.exe.Mchet.login.dao;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exe.Mchet.login.domain.LoginVO;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;


@Repository //dao bean으로 등록
public class LoginDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public void createUser(LoginVO vo) {
		mybatis.insert("LoginMapper.createUser", vo);//입력되어 저장되어있는 vo를 insert
		System.out.println("===> Mybatis로 createUser() 기능 처리");
	}

	public void updateUser(LoginVO vo) {
		mybatis.update("LoginMapper.updateUser", vo);
		System.out.println("===> Mybatis로 updateUser() 기능 처리");
	}

	public void deleteBoard(LoginVO vo) {
		System.out.println("===> Mybatis로 deleteUser() 기능 처리");
		mybatis.delete("LoginMapper.deleteUser", vo);
	}

	public LoginVO getContent(LoginVO vo) {
		System.out.println("===> Mybatis로 getContent() 기능 처리");
		return (LoginVO) mybatis.selectOne("LoginMapper.getContent", vo);
	}

	public List<LoginVO> getLoginList() {
		System.out.println("===> Mybatis로 getUserList() 기능 처리");
		return mybatis.selectList("LoginMapper.getBoardList");
	}
}

//import org.apache.ibatis.session.SqlSession;
//public void 클래스이름/기능이름(기능VO vo /데이터를 저장할 VO) {
//	System.out.println("===> Mybatis로 클래스이름/기능이름) 기능 처리" / 콘솔에서 작동 여부 확인);
//	mybatis (or sqlSession).selectList/selectOne/insert/update/delete(" *Mapper.메퍼의 기능", vo);
//}
//입력되어 저장되어있는 vo를 이용해 매퍼의 기능 수행
