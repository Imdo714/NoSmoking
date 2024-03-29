package com.kh.video.controller;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import com.kh.member.model.vo.Member;
import com.kh.video.model.service.videoService;
import com.kh.video.model.vo.video;

@Controller
public class videoController {

	@Autowired
	public videoService video;
	
	@RequestMapping("/video.vi")
    public ModelAndView videoList(@RequestParam(value="cpage", defaultValue="1") int currentPage, ModelAndView mv) {
        
		PageInfo pi = Pagenation.getPageInfo(video.selectVideoCount(), currentPage, 5, 8);
		
		ArrayList<video> list = video.videoListAll(pi);
		
		mv.addObject("list", list)
		  .addObject("pi", pi)
		  .setViewName("video/videoList");
		
        return mv;
    }
	
	@ResponseBody
	@RequestMapping(value="/videoUp.vi", produces="application/json; charset=UTF-8")
    public String videoUp(String title, String videoAddress, ModelAndView mv, HttpSession session) {

		int res = 0;
		
		Member m = (Member) session.getAttribute("loginUser");
		int userNo = m.getUserNo();
		
		String patternString = "<iframe[^>]*?src=\"([^\"]*)\"[^>]*?title=\"([^\"]*)\"[^>]*?>";
        Pattern pattern = Pattern.compile(patternString);
        
        Matcher matcher = pattern.matcher(videoAddress);
        if (matcher.find()) {
        	String srcAttributeValue = matcher.group(1);
            
            res = video.videoUpload(title, srcAttributeValue, userNo);
            
        } else {
            System.out.println("일치하는 패턴을 찾지 못했습니다.");
        }
		
		if(res > 0) {
			mv.addObject("message", "성공");
		} else {
			mv.addObject("message", "실패");
		}
		
        return new Gson().toJson(mv);
    }
	
	
	@ResponseBody
	@RequestMapping(value="/videoAllList.vi", produces="application/json; charset=UTF-8")
    public String videoAllList(@RequestParam(value="cpage", defaultValue="1") int currentPage, ModelAndView mv, HttpSession session) {

		PageInfo pi = Pagenation.getPageInfo(video.selectVideoCount(), currentPage, 5, 8);
		
		ArrayList<video> list = video.videoListAll(pi);
		
		mv.addObject("list", list)
		  .addObject("pi", pi);
		
        return new Gson().toJson(mv);
    }
	
	@RequestMapping(value="/detailVideo.vi")
    public ModelAndView detailVideo(int vNo, ModelAndView mv, HttpSession session) {
		int videoNo = vNo;
		
		ArrayList<video> list = video.videoDetail(videoNo);
		
		mv.addObject("list", list)
		  .setViewName("video/videoDetail");
		
		return mv;
    }
	

	
	
}
