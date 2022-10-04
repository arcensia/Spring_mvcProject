package com.exe.Mchet.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exe.Mchet.domain.BoardVO;
import com.exe.Mchet.service.BoardService;
// 출처 https://ming9mon.tistory.com/65?category=825118
@Controller
public class MainController {
	@Autowired
	private BoardService boardService;
	@RequestMapping("/")
	public String getMain(BoardVO vo, Model model) {

		List<BoardVO> boardList = boardService.getBoardList();
		 
		// Model 정보 저장
		model.addAttribute("boardList",boardList);
		
		return "index"; // View 이름 리턴
	}
	
}
