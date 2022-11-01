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
//  https://ming9mon.tistory.com/65?category=825118

@Controller
@SessionAttributes("login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	//
	@RequestMapping("/moveSignup.do") 
	public String moveSingupPage()throws Exception{
		return "login/signupPage";
	}
	
	//
	@RequestMapping("/createUser.do") 
	public String createUser(LoginVO vo)throws IOException{
		loginService.createUser(vo);
		return "redirect:getBoardList.do";
	}
}
