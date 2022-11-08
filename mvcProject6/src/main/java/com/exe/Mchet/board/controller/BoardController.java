package com.exe.Mchet.board.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.exe.Mchet.board.domain.BoardVO;
import com.exe.Mchet.board.service.BoardService;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	

	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		 List<BoardVO> boardList = boardService.getBoardList();
		 
		// Model 
		model.addAttribute("boardList",boardList);
		return "board/boardList"; // View �씠由� 由ы꽩
	}


	@RequestMapping("/getContent.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getContent(vo)); // Model �젙蹂� ���옣
		return "board/content"; // View �씠由� 由ы꽩
	}
	

	@RequestMapping(value="/insertBoard.do") 
	public String insertBoard(BoardVO vo) throws IOException { 
			boardService.insertBoard(vo); 
			return "redirect:getBoardList.do"; 
	}
	

	@RequestMapping("/moveInsertBoard.do") 
	public String moveInsertBoard()throws Exception{
		return "board/insertBoard";
	}
	 


	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		boardService.updateBoard(vo);
		return "redirect:getBoardList.do";
	}


	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}
}
//	redirect -> servlet-context.xml-> getBoardList.do-> /WEB-INF/views/ -> getBoardList.do.jsp . 
//	redirect- > getBoardList.do.jsp .

