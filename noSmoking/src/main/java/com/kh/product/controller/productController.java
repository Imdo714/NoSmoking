package com.kh.product.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.kh.common.template.Pagenation;
import com.kh.common.vo.PageInfo;
import com.kh.member.model.vo.Member;
import com.kh.product.model.service.ProductService;
import com.kh.product.model.vo.Cart;
import com.kh.product.model.vo.Payment;
import com.kh.product.model.vo.Product;
import com.kh.product.model.vo.ProductImg;

@Controller
public class productController {
	
	@Autowired
	public ProductService productService;
	

	@RequestMapping("/product.pr")
    public String product() {
        
        return "product/productList";
    }
	
	
	public String saveFile(MultipartFile upfile, HttpSession session, String filepath) {
		  
	      String originName = upfile.getOriginalFilename();
	      
	      String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(0));
	      
	      int ranNum = (int)(Math.random() * 90000) + 10000;
	      
	      String ext = originName.substring(originName.lastIndexOf("."));
	      
	      String changeName = currentTime + ranNum + ext;
	      
	      String savePath = session.getServletContext().getRealPath(filepath);
	      
	      try {
	         upfile.transferTo(new File(savePath + changeName));
	      } catch (IllegalStateException | IOException e) {
	         e.printStackTrace();
	      }
	      
	      return changeName;
	   }
	
	
	@RequestMapping("/insertProduct.pr")
    public ModelAndView insertProduct(Product p, ArrayList<MultipartFile> upfile, HttpSession session, ModelAndView mv) {
    
		int result = productService.insertProduct(p);
		int resultImg = 1;
		
		for(MultipartFile mf : upfile) {
			//전달된 파일이 있을 경우 => 파일명 수정 후 서버 업로드 => 원본명, 서버업로드된 경로로 DB에 담기(파일이 있을때만)
			if(!mf.getOriginalFilename().equals("")) {
				ProductImg pi = new ProductImg();
				String changeName = saveFile(mf, session, "resources/img/product/productInsert/");
				
				pi.setProductUrl("resources/img/product/productInsert/");
				pi.setProductOrginName(mf.getOriginalFilename());
				pi.setProductChangName("resources/img/product/productInsert/" + changeName);
				
				resultImg = resultImg * productService.insertProductImg(pi);
			}
		}
		
		if(result * resultImg > 0) {
			session.setAttribute("alertMsg", "상품 등록이 완료되었습니다.");
			mv.setViewName("redirect:/");
		} else {
			session.setAttribute("alertMsg", "상품 등록에 실패하였습니다.");
		}
		
        return mv;
    }
	
	@RequestMapping(value="/productList.pr")
    public ModelAndView productList(@RequestParam(value="cpage", defaultValue="1") int currentPage, ModelAndView mv) {
		
		PageInfo pi = Pagenation.getPageInfo(productService.selectListCount(), currentPage, 5, 6);
		
		ArrayList<Product> list = productService.selectProductList(pi);

		ArrayList<ProductImg> firstImage = new ArrayList<>();
		
		// 이미지 가져오기
		for(int i= 0; i < list.size(); i++) {
			int pNo = list.get(i).getProductNo();
			
			ArrayList<ProductImg> img = productService.selectProductImg(pNo);
			
			if (img != null && !img.isEmpty()) {
			    firstImage.add(img.get(0));
			}
		}
		
		mv.addObject("pi", pi)
		  .addObject("list", list)
		  .addObject("firstImage", firstImage)
		  .setViewName("product/productList");
		
        return mv;
    }
	
	
	@RequestMapping(value="/productDetailView.pr")
    public ModelAndView productDetailView(@RequestParam(value="cpage", defaultValue="1") int currentPage, int pNo, ModelAndView mv) {
        
		ArrayList<Product> list = productService.productDetail(pNo);
		
		ArrayList<ProductImg> pImg = productService.productDetailImg(pNo);
		
		PageInfo pi = Pagenation.getPageInfo(productService.selectListCount(), currentPage, 5, 4);
		ArrayList<Product> proList = productService.selectProductList(pi);

		ArrayList<ProductImg> firstImage = new ArrayList<>();
		
		// 이미지 가져오기
		for(int i= 0; i < proList.size(); i++) {
			int pNo2 = proList.get(i).getProductNo();
			
			ArrayList<ProductImg> img = productService.selectProductImg(pNo2);
			
			if (img != null && !img.isEmpty()) {
			    firstImage.add(img.get(0));
			}
		}
		
		mv.addObject("pImg", pImg)
		  .addObject("list", list)
		  .addObject("proList", proList)
		  .addObject("firstImage", firstImage)
		  .setViewName("product/prdouctDetail");
		
        return mv;
    }
	
	@ResponseBody
	@RequestMapping(value="/productRefesh.pr", produces="application/json; charset=UTF-8")
    public String productRefesh(@RequestParam(value="cpage", defaultValue="1") int currentPage, ModelAndView mv) {
		
		PageInfo pi = Pagenation.getPageInfo(productService.selectListCount(), currentPage, 5, 4);
		
		ArrayList<Product> list = productService.selectProductList(pi);

		ArrayList<ProductImg> firstImage = new ArrayList<>();
		
		// 이미지 가져오기
		for(int i= 0; i < list.size(); i++) {
			int pNo = list.get(i).getProductNo();
			
			ArrayList<ProductImg> img = productService.selectProductImg(pNo);
			
			if (img != null && !img.isEmpty()) {
			    firstImage.add(img.get(0));
			}
		}
		
		mv.addObject("pi", pi)
		  .addObject("list", list)
		  .addObject("firstImage", firstImage);
		
        return new Gson().toJson(mv);	
    }
	
	@ResponseBody
	@RequestMapping(value="/cart.pr", produces="application/json; charset=UTF-8")
    public String cart(int userNo, int productNo, int count, ModelAndView mv) {
		 
		int sele = productService.selectCartShop(userNo, productNo);
		
		if(sele == 0) {
			int shop = productService.insertCart(userNo, productNo, count);
			
			mv.addObject("productNo", productNo)
			  .addObject("userNo", userNo)
			  .addObject("message", "성공");
		} else {
			mv.addObject("productNo", productNo)
			  .addObject("userNo", userNo)
			  .addObject("message", "실패");
		}
		
        return new Gson().toJson(mv);
    }
	
	@RequestMapping(value="/shopeCart.pr")
    public ModelAndView shopeCart(HttpSession session, ModelAndView mv) {
        
		Member m = (Member) session.getAttribute("loginUser");
		int userNo = m.getUserNo();
		
		ArrayList<Cart> list = productService.selectCart(userNo);
		
		ArrayList<ProductImg> firstImage = new ArrayList<>();
		ArrayList<Product> product = new ArrayList<>();
		
		for(int i = 0; i < list.size(); i++) {
			int productNo = list.get(i).getProductNo();
			
			ArrayList<Product> aaa = productService.selectProduct(productNo);
			if(aaa != null) {
				product.add(aaa.get(0));
			}
			
			ArrayList<ProductImg> img = productService.selectProductImg(productNo);
			
			if (img != null && !img.isEmpty()) {
			    firstImage.add(img.get(0));
			}
		}
		
		mv.addObject("list", list)
		  .addObject("product", product)
		  .addObject("firstImage", firstImage)
		  .setViewName("cart/cart");
		
        return mv;
    }
	
	
	@RequestMapping(value="/cartUpdate.pr")
    public ModelAndView cartUpdate(int pNo, ModelAndView mv) {
        
		ArrayList<Product> list = productService.productDetail(pNo);
		
		ArrayList<ProductImg> pImg = productService.productDetailImg(pNo);
		
		mv.addObject("pImg", pImg)
		  .addObject("list", list)
		  .setViewName("cart/cartUpdate");
		
        return mv;
    }
	
	@ResponseBody
	@RequestMapping(value="/cartUpdateCount.pr", produces="application/json; charset=UTF-8")
    public String cartUpdateCount(int count, int productNo, ModelAndView mv, HttpSession session) {
        
		Member m = (Member) session.getAttribute("loginUser");
		int userNo = m.getUserNo();
		
		int cartCount = productService.cartUpdateCount(count, userNo, productNo);
		
		if(cartCount > 0) {
			mv.addObject("productNo", productNo)
			  .addObject("userNo", userNo)
			  .addObject("message", "성공");
		} else {
			mv.addObject("message", "실패");
		}
		
        return new Gson().toJson(mv);
    }
	
	
	@RequestMapping(value="cartDelete.pr", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String cartDelete(String realData, ModelAndView mv, HttpSession session) {
		
		Member m = (Member) session.getAttribute("loginUser");
		int userNo = m.getUserNo();
		int result = 0;
		
	    // realData를 JSON으로 파싱하여 사용
	    JsonArray jsonArray = new JsonParser().parse(realData).getAsJsonArray();
	    System.out.println("받은 상품 번호들: " + jsonArray);
	    
	    for(JsonElement element : jsonArray) {
	    	int productNo = element.getAsInt();
	    	 
	    	result = productService.deleteCart(productNo, userNo);
	    }
	    
	    if(result > 0) {
	    	mv.addObject("message", "성공");
	    } else {
	    	mv.addObject("message", "실패");
	    }

        return new Gson().toJson(mv);
	}
	
	
	
	
	
}
