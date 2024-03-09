package com.kh.common.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.kh.member.model.vo.Member;
import com.kh.product.model.service.ProductService;
import com.kh.product.model.vo.Payment;

@Controller
public class kakaoController {

	@Autowired
	public ProductService productService;
	
	@ResponseBody
	@RequestMapping(value="kakao.pr", produces="application/json; charset=UTF-8")
	public String kakaopay(int productNo, int price, ModelAndView mv, HttpSession session) {
		
		try {
			URL address = new URL("https://kapi.kakao.com/v1/payment/ready"); 	// 주소 
			HttpURLConnection join =  (HttpURLConnection) address.openConnection(); // 서버 연결
			join.setRequestMethod("POST"); 
			join.setRequestProperty("Authorization", "KakaoAK 5ec0b38b846924ddb31e67e0cc96795c"); 
			join.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			join.setDoOutput(true);
			String parameter = "cid=TC0ONETIME&partner_order_id=partner_order_id&partner_user_id=partner_user_id&item_name=No Smoking&quantity=1&total_amount=" + price + "&tax_free_amount=0&approval_url=http://localhost:8018/smoking/kakaoPoint.me?pNo=" + productNo + "&cancel_url=http://localhost:8018/smoking/kakaoPoint.me?pNo=" + productNo + "&fail_url=http://localhost:8018/smoking/shopeCart.pr";
			// parameter = 파라미터 
			OutputStream sendPay = join.getOutputStream(); // 데이터를 줄수 있게 만듬
			DataOutputStream sendData = new DataOutputStream(sendPay); // 데이터를 주는 애 
			sendData.writeBytes(parameter); // 문자열을 형변환 시켜줌
			sendData.close(); // 자기가 가지고있는 바이트를 서버로 전송함 
			
			int result = join.getResponseCode(); // 결과 
			
			InputStream getResult; // 받는 애
			if(result == 200) { // 200이면 성공 나머지는 다 실패
				getResult = join.getInputStream();
			} else {
				getResult = join.getErrorStream();
			}
			InputStreamReader captain = new InputStreamReader(getResult); // 받은 거에서 읽어주는 역할
			BufferedReader charginWrite = new BufferedReader(captain); // 읽어주는거 받아서 형변환 시켜주기
			
			Member loginUser = (Member)session.getAttribute("loginUser");
			
			int payPoint = price;
			Payment pay = new Payment();
			pay.setPayPoint(payPoint);
			
			session.setAttribute("pay", pay);
			
			return charginWrite.readLine();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	
	@RequestMapping(value= "kakaoPoint.me")
	public String successPay(String pg_token, int pNo, ModelAndView mv, HttpSession session) {
		
		Payment p = (Payment)session.getAttribute("pay");
		int point = p.getPayPoint();
		
		Member m = (Member) session.getAttribute("loginUser");
		int userNo = m.getUserNo();
		
		if(pg_token != null) { // 토큰이 있을 때
			int res = productService.deleteCart(pNo, userNo);
			int ser = productService.insertPayment(userNo, point);
			
			session.setAttribute("alertMsg", "결제가 완료되었습니다.");
			return "redirect:/main.me";
		} else {
			session.setAttribute("alertMsg", "결제중 에러 발생");
			return "redirect:/shopeCart.pr";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="teamKakao.pr", produces="application/json; charset=UTF-8")
	public String teamKakaopay(String realData, int sum, ModelAndView mv, HttpSession session) {
	
		try {
			URL address = new URL("https://kapi.kakao.com/v1/payment/ready"); 	// 주소 
			HttpURLConnection join =  (HttpURLConnection) address.openConnection(); // 서버 연결
			join.setRequestMethod("POST"); 
			join.setRequestProperty("Authorization", "KakaoAK 5ec0b38b846924ddb31e67e0cc96795c"); 
			join.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			join.setDoOutput(true);
			String parameter = "cid=TC0ONETIME&partner_order_id=partner_order_id&partner_user_id=partner_user_id&item_name=No Smoking&quantity=1&total_amount=" + sum + "&tax_free_amount=0&approval_url=http://localhost:8018/smoking/TkakaoPoint.me&cancel_url=http://localhost:8018/smoking/TkakaoPoint.me&fail_url=http://localhost:8018/smoking/shopeCart.pr";
			// parameter = 파라미터 
			OutputStream sendPay = join.getOutputStream(); // 데이터를 줄수 있게 만듬
			DataOutputStream sendData = new DataOutputStream(sendPay); // 데이터를 주는 애 
			sendData.writeBytes(parameter); // 문자열을 형변환 시켜줌
			sendData.close(); // 자기가 가지고있는 바이트를 서버로 전송함 
			
			int result = join.getResponseCode(); // 결과 
			
			InputStream getResult; // 받는 애
			if(result == 200) { // 200이면 성공 나머지는 다 실패
				getResult = join.getInputStream();
			} else {
				getResult = join.getErrorStream();
			}
			InputStreamReader captain = new InputStreamReader(getResult); // 받은 거에서 읽어주는 역할
			BufferedReader charginWrite = new BufferedReader(captain); // 읽어주는거 받아서 형변환 시켜주기
			
			Member loginUser = (Member)session.getAttribute("loginUser");
			
			int payPoint = sum;
			Payment pay = new Payment();
			pay.setPayPoint(payPoint);
			
//			JsonArray jsonArray = new JsonParser().parse(realData).getAsJsonArray();
			session.setAttribute("realData", realData);
			session.setAttribute("pay", pay);
			
			return charginWrite.readLine();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	
	@RequestMapping(value= "TkakaoPoint.me")
	public String successTPay(String pg_token, ModelAndView mv, Model model, HttpSession session) {
		
		Payment p = (Payment)session.getAttribute("pay");
		int point = p.getPayPoint();
		
		Member m = (Member)session.getAttribute("loginUser");
		int userNo = m.getUserNo();
		
		String ProductNo = (String) session.getAttribute("realData");
		
		JsonArray jsonArray = new JsonParser().parse(ProductNo).getAsJsonArray();
		
		if(pg_token != null) { // 토큰이 있을 때
		    for(JsonElement element : jsonArray) {
		    	int pNo = element.getAsInt();
		    	
		    	int res = productService.deleteCart(pNo, userNo);
		    }
			
			int ser = productService.insertPayment(userNo, point);
			
			session.setAttribute("alertMsg", "결제가 완료되었습니다.");
			return "redirect:/main.me";
		} else {
			model.addAttribute("errorMsg", "결제중 에러 발생");
			return "redirect:/shopeCart.pr";
		}
		
	}
}
