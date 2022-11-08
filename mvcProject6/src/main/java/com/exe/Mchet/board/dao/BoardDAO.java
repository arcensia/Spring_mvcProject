package com.exe.Mchet.board.dao;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exe.Mchet.board.domain.BoardVO;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertBoard(BoardVO vo) {
		System.out.println("===> Mybatis insertBoard()");
		mybatis.insert("BoardMapper.insertBoard", vo);
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("===> Mybatis updateBoard()━");
		mybatis.update("BoardMapper.updateBoard", vo);
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Mybatis deleteBoard()");
		mybatis.delete("BoardMapper.deleteBoard", vo);
	}

	public BoardVO getContent(BoardVO vo) {
		System.out.println("===> Mybatis get content");
		return (BoardVO) mybatis.selectOne("BoardMapper.getContent", vo);
	}

	public List<BoardVO> getBoardList() {
		System.out.println("===> Mybatis getBoardList()");
		return mybatis.selectList("BoardMapper.getBoardList");
	}
}
