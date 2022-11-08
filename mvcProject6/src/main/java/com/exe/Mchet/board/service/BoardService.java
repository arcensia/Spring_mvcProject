package com.exe.Mchet.board.service;

import java.util.List;

import com.exe.Mchet.board.domain.BoardVO;

public interface BoardService {
	

	List<BoardVO> getBoardList();
	

	BoardVO getContent(BoardVO vo);
	

	void insertBoard(BoardVO vo);


	void updateBoard(BoardVO vo);


	void deleteBoard(BoardVO vo);
}
