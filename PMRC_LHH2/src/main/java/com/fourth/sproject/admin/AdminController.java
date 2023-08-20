package com.fourth.sproject.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fourth.sproject.member.MemberDAO;

@Controller
public class AdminController {
	 
		@Autowired
		MemberDAO mDAO;
	    
	    @Autowired
		AdminDAO aDAO;
	    
		@RequestMapping(value="/go.admin" ,method=RequestMethod.GET)
		public String goBoard(HttpServletRequest req) {
			if (mDAO.isLogined(req)) {
				aDAO.clearSearch(req);
				aDAO.getMember(1, req);
				req.setAttribute("cp", "board/adminH.jsp");
				return "index";
			}else {
				return "login";
			}
		}
		
		@RequestMapping(value="/go.adminP" ,method=RequestMethod.GET)
		public String goBoardPage(@RequestParam(value="page") int p, HttpServletRequest req) {
			if (mDAO.isLogined(req)) {
				aDAO.getMember(p, req);
				req.setAttribute("cp", "board/adminH.jsp");
				return "index";
			}else {
				return "login";
			}
			
		}
		
		@RequestMapping(value="/member.search", method=RequestMethod.GET)
		public String searchPost(@RequestParam(value="search") String search, HttpServletRequest req) {
			if (mDAO.isLogined(req)) {
				aDAO.search(search, req);
				aDAO.getMember(1, req);
				req.setAttribute("cp", "board/adminH.jsp");
				return "index";
			}else {
				return "login";
			}
		}
}
