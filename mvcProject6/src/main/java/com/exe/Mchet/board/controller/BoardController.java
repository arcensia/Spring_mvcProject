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
	
	//글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		 List<BoardVO> boardList = boardService.getBoardList();
		 
		// Model 정보 저장
		model.addAttribute("boardList",boardList);
		return "board/boardList"; // View 이름 리턴
	}

	// 글 상세 조회
	@RequestMapping("/getContent.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getContent(vo)); // Model 정보 저장
		return "board/content"; // View 이름 리턴
	}
	
	// 글 쓰기
	@RequestMapping(value="/insertBoard.do") 
	public String insertBoard(BoardVO vo) throws IOException { 
			boardService.insertBoard(vo); 
			return "redirect:getBoardList.do"; 
	}
	
	// 글 쓰기 페이지 이동
	@RequestMapping("/moveInsertBoard.do") 
	public String moveInsertBoard()throws Exception{
		return "board/insertBoard";
	}
	 

	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		boardService.updateBoard(vo);
		return "redirect:getBoardList.do";
	}

	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}
}
//	글 수정과 글 삭제에 redirect를 써준 이유는 servlet-context.xml 설정때문에 getBoardList.do로 가는것이 아닌 /WEB-INF/views/에 있는 getBoardList.do.jsp로 가기때문이다. 
//	redirect를 안써주게 되면 당연히 getBoardList.do.jsp파일이 없어 어 404에러가 난다.

