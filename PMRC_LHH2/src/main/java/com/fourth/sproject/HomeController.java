package com.fourth.sproject;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fourth.sproject.board.BoardDAO;
import com.fourth.sproject.member.Member;
import com.fourth.sproject.member.MemberDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	MemberDAO mDAO;
	
	@Autowired
	BoardDAO bDAO;
	
	private boolean firstReq;
	
	public HomeController() {
		firstReq = true;
	}
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String goIndex(HttpServletRequest req) {
		if (firstReq) {
//			bDAO.setAllPostCount();
			firstReq = false;
			return "login";
		}else {
			if (mDAO.isLogined(req)) {
				return "index";
			}else {
				return "login";
			}
		}
	}
	
	@RequestMapping(value = "/goindex.go", method = RequestMethod.GET)
	public String goIndex2(HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			return goIndex(req);
		}else {
			return "login";
		}
	}
	
	@RequestMapping(value = "/index.go", method = RequestMethod.GET)
	public String indexGo2(HttpServletRequest req) {
		mDAO.isLogined(req);
		if (mDAO.isLogined(req)) {
			return "index";
		}else {
			return "login";
		}
	}
	
	@RequestMapping(value = "/member.logout", method = RequestMethod.POST)
	public String memberLogout(Member m, HttpServletRequest req) {
		mDAO.logout(req);
		firstReq = true;
		return goIndex(req);
	}
	
}
