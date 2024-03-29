package com.kh.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

@Controller
public class memberController {
	
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	

	@RequestMapping("/writer.me")
    public String writer() {
        
        return "member/writer";
    }
	
	
	@RequestMapping("/login.me")
    public String login() {
        
        return "member/login";
    }
	
	@RequestMapping("/main.me")
    public String main() {
        
        return "redirect:/";
    }
	
	@RequestMapping("/error.me")
    public String error() {
        
        return "common/errorPage";
    }
	
	@RequestMapping("/insertMember.me")
    public String insertMember() {
        
        return "member/insertMember";
    }
	

	@RequestMapping(value="/logout.me")
    public String logout(HttpSession session) {
		
		session.removeAttribute("loginUser");
		
        return "redirect:/";
    }
	
	@RequestMapping("/loginMember.me")
    public ModelAndView loginMember(Member m, HttpSession session, ModelAndView mv) {
        
		Member loginUser = memberService.loginMember(m.getUserId()); //아이디로만 멤버객체 가져오기
		
		if(loginUser == null || !bcryptPasswordEncoder.matches(m.getUserPwd(), loginUser.getUserPwd())) { // 로그인실패 => 에러문구를 requestScope에 담고 에러페이지로 포워딩
			mv.addObject("errorMsg", "로그인 실패");
			mv.setViewName("common/errorPage");
		} else {
			session.setAttribute("loginUser", loginUser);
			mv.setViewName("redirect:/");
		}
		
        return mv;
    }
	
	@ResponseBody
	@RequestMapping(value="/insert.me", produces="application/json; charset=UTF-8")
    public String insert(Member m, HttpSession session, Model model, ModelAndView mv) {
		
		System.out.println(m);
		int res = memberService.smokingInsert(m);
		System.out.println(res);
		// 암호화 작업
//		String encPwd = bcryptPasswordEncoder.encode(m.getUserPwd());
		
//		m.setUserPwd(encPwd); 
		// Member객체에 userPwd필드에 평문이 아닌 암호문으로 변경
		
//		int result = memberService.insertMember(m);

		
		if(res > 0) {
			mv.addObject("message", "안돼");
			return new Gson().toJson(mv);
		} else {
				// 암호화 작업
				String encPwd = bcryptPasswordEncoder.encode(m.getUserPwd());
				
				m.setUserPwd(encPwd); // Member객체에 userPwd필드에 평문이 아닌 암호문으로 변경
				
				int result = memberService.insertMember(m);
				
				if(result > 0) {
					mv.addObject("message", "성공");
					return new Gson().toJson(mv);
				} else {
					mv.addObject("message", "실패");
					return new Gson().toJson(mv);
				}
			
		}
		
		
    }
	
	@ResponseBody
	@RequestMapping(value="/writerInsert.me", produces="application/json; charset=UTF-8")
    public String writer(ModelAndView mv, HttpSession session) {
        
		Member m = (Member) session.getAttribute("loginUser");
		int userNo = m.getUserNo();
		
		int result = memberService.writerSearch(userNo);
		
		if(result == 0) {
			int result2 = memberService.insertWriter(userNo);
			
			mv.addObject("message", "성공");
		} else {
			mv.addObject("message", "실패");
		}
        return new Gson().toJson(mv);
    }

	
	@ResponseBody
	@RequestMapping(value="noSmokingcount.me", produces="application/json; charset=UTF-8")
    public String smokingCount(ModelAndView mv, HttpSession session) {
		
		int co = memberService.smokingCount();
		
		mv.addObject("co", co);
		return new Gson().toJson(mv);
	}
	
	
	
	
}
