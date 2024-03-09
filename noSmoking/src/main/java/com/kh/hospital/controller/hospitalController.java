package com.kh.hospital.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kh.common.template.Pagenation;
import com.kh.common.vo.PageInfo;
import com.kh.hospital.model.service.HospitalService;
import com.kh.hospital.model.vo.Hospital;
import com.kh.hospital.model.vo.Reply;
import com.kh.member.model.vo.Member;
import com.kh.product.model.vo.Product;

@Controller
public class hospitalController {

	@Autowired
	private HospitalService hospitalService;
	
	@RequestMapping("/searchHospital.ho")
    public ModelAndView searchHospital(@RequestParam(value="cpage", defaultValue="1") int currentPage, ModelAndView mv) {
        
		PageInfo pi = Pagenation.getPageInfo(hospitalService.hospitalCount(), currentPage, 5, 6);
		
		ArrayList<Hospital> list = hospitalService.selectHospital(pi);
		
		mv.addObject("pi", pi)
		  .addObject("list", list)
		  .setViewName("hospital/hospitalList");
		
        return mv;
    }
	
	@ResponseBody
	@RequestMapping(value="/search.ho", produces="application/json; charset=UTF-8")
    public String search(String comment, ModelAndView mv) {
		
		ArrayList<Hospital> list = hospitalService.selectSearch(comment);
		
		mv.addObject("list", list);
			
        return new Gson().toJson(mv);
    }
	
	@ResponseBody
	@RequestMapping(value="/searchCity.ho", produces="application/json; charset=UTF-8")
    public String searchCity(String comment, ModelAndView mv) {
		
		ArrayList<Hospital> list = hospitalService.selectSearchCity(comment);
		
		mv.addObject("list", list);
        return new Gson().toJson(mv);
    }
	
	@ResponseBody
	@RequestMapping(value="/searchAddres.ho", produces="application/json; charset=UTF-8")
    public String searchAddres(String comment, ModelAndView mv) {
		
		ArrayList<Hospital> list = hospitalService.selectSearchAddres(comment);
		
		mv.addObject("list", list);
        return new Gson().toJson(mv);
    }
	
	@ResponseBody
	@RequestMapping(value="/searchPhone.ho", produces="application/json; charset=UTF-8")
    public String searchPhone(String comment, ModelAndView mv) {
		
		ArrayList<Hospital> list = hospitalService.selectSearchPhone(comment);
		
		mv.addObject("list", list);
        return new Gson().toJson(mv);
    }
	
	
	@RequestMapping("/hospitalDetail.ho")
    public ModelAndView detailHospital(int hNo, @RequestParam(value="cpage", defaultValue="1") int currentPage, ModelAndView mv) {
        
		Hospital result =  hospitalService.detailHospital(hNo);
		
		PageInfo pi = Pagenation.getPageInfo(hospitalService.selectReplyCount(hNo), currentPage, 5, 6);
		
		ArrayList<Reply> list2 = hospitalService.selectReplyList(pi, hNo);
		
		mv.addObject("result", result)
		  .addObject("list2", list2)
		  .addObject("pi", pi)
		  .setViewName("hospital/hospitalDetail");
		
        return mv;
    }
	
	@ResponseBody
	@RequestMapping(value="/hospitalReply.ho", produces="application/json; charset=UTF-8")
    public String Reply(String comment, int hNo, int userNo2, @RequestParam(value="cpage", defaultValue="1") int currentPage, ModelAndView mv, HttpSession session) {
		
		Member m = (Member) session.getAttribute("loginUser");
		int userNo = m.getUserNo();
		
		int res = hospitalService.insertReply(comment, hNo, userNo);
		
		PageInfo pi = Pagenation.getPageInfo(hospitalService.selectReplyCount(hNo), currentPage, 5, 6);
		
		ArrayList<Reply> list = hospitalService.selectReplyList(pi, hNo);
		
		mv.addObject("list", list)
		  .addObject("pi", pi)
		  .addObject("hNo", hNo)
		  .addObject("userNo", userNo2);
		
        return new Gson().toJson(mv);
    }
	
	@ResponseBody
	@RequestMapping(value="/replyDelete.ho", produces="application/json; charset=UTF-8")
    public String deleteReply(int replyNo, int hNo, int userNo2, @RequestParam(value="cpage", defaultValue="1") int currentPage, ModelAndView mv) {
		
		int res = hospitalService.deleteReply(replyNo);
		
		PageInfo pi = Pagenation.getPageInfo(hospitalService.selectReplyCount(hNo), currentPage, 5, 6);
		
		ArrayList<Reply> list = hospitalService.selectReplyList(pi, hNo);
		
		if(res > 0) {
			mv.addObject("message", "성공")
			  .addObject("list", list)
			  .addObject("hNo", hNo)
			  .addObject("userNo", userNo2);
			
			return new Gson().toJson(mv);
		}else {
			mv.addObject("message", "실패")
			  .addObject("list", list)
			  .addObject("hNo", hNo)
			  .addObject("userNo", userNo2);
			
			return new Gson().toJson(mv);
		}
    }
	
	@ResponseBody
	@RequestMapping(value="/replyUpdate.ho", produces="application/json; charset=UTF-8")
    public String updateReply(String content, int replyNo, int hNo, int userNo2, @RequestParam(value="cpage", defaultValue="1") int currentPage, ModelAndView mv) {
	
		int ReplyUp = hospitalService.updateReply(content, replyNo);
		
		PageInfo pi = Pagenation.getPageInfo(hospitalService.selectReplyCount(hNo), currentPage, 5, 6);
		
		ArrayList<Reply> list = hospitalService.selectReplyList(pi, hNo);
		
		if(ReplyUp > 0) {
			mv.addObject("message", "성공")
			  .addObject("list", list)
			  .addObject("hNo", hNo)
			  .addObject("userNo", userNo2);
			
			return new Gson().toJson(mv);
		}else {
			mv.addObject("message", "실패")
			  .addObject("list", list)
			  .addObject("hNo", hNo)
			  .addObject("userNo", userNo2);
			
			return new Gson().toJson(mv);
		}
		
		
    }

	
	
}
