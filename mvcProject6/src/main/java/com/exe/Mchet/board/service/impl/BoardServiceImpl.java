package com.exe.Mchet.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exe.Mchet.board.dao.BoardDAO;
import com.exe.Mchet.board.domain.BoardVO;
import com.exe.Mchet.board.service.BoardService;


@Service
public class BoardServiceImpl implements BoardService{
	@Autowired//bean을 주입하는 것들. spring been 클래스라 인식함. @Controller, @service, @repository, @component
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> getBoardList() {
		return boardDAO.getBoardList();
	}

	@Override
	public BoardVO getContent(BoardVO vo) {
		return boardDAO.getContent(vo);
	}

	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}
}
