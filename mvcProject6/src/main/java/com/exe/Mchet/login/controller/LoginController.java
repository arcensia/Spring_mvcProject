package com.exe.Mchet.login.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.List;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.exe.Mchet.login.domain.LoginVO;
import com.exe.Mchet.login.service.LoginService;
import javax.inject.Inject;



import org.springframework.web.servlet.ModelAndView;

//  https://ming9mon.tistory.com/65?category=825118

@Controller
@SessionAttributes("login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
//	회원가입
	@RequestMapping("/moveSignup.do") 
	public String moveSingupPage()throws Exception{
		return "login/signupPage";
	}
	
	@RequestMapping("/createUser.do")
	public String createUser(LoginVO vo)throws IOException{
		loginService.createUser(vo);
		return "redirect:getBoardList.do";
	}
	
	
	
	
//	로그인
//	@Inject
//	LoginService loginService;
	
	@RequestMapping("/login.do")
	public String login() throws Exception{
		return "login/loginPage";
	}
	
	@RequestMapping("/loginCheck.do")
	public ModelAndView login_check(@ModelAttribute LoginVO vo, HttpSession session) {
		System.out.println(vo.getId());
		System.out.println(vo.getPw());
		String name = loginService.loginCheck(vo, session);
		ModelAndView mav = new ModelAndView();
		if(name != null) {// 여기서 로그인, 거부 여부 체크
			mav.setViewName("redirect:getBoardList.do");
			System.out.println(name);
		}else {
			System.out.println(name);
			mav.setViewName("login/loginPage");
			mav.addObject("massage","error");
		}
		return mav;
	}
	
	
//	@RequestMapping("/loginCheck.do")
//	public ModelAndView login_check(@ModelAttribute LoginVO vo, HttpSession session) {
//		String name = loginService.loginCheck(vo, session);
//		ModelAndView mav = new ModelAndView();
//		if(name != null) {// 여기서 로그인, 거부 여부 체크
//			mav.setViewName("index");
//		}else {
//			mav.setViewName("login/loginPage");
//			mav.addObject("massage","error");
//		}
//		return mav;
//	}
	
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session, ModelAndView mav) {
		loginService.logout(session); 
		mav.setViewName("/loginPage"); 
		mav.addObject("message", "logout"); 
		return mav;
	  }
	
	
}
