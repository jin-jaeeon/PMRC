package com.fourth.sproject.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fourth.sproject.DateManager;

@Controller
public class MemberController {
	
	@Autowired
	MemberDAO mDAO;
	
	@RequestMapping(value="join.go", method=RequestMethod.GET)
	public String goJoin(HttpServletRequest req) {
		DateManager.getCurYear(req);
		return "member/join";
	}
	
	@RequestMapping(value="find.go", method=RequestMethod.GET)
	public String findID() {
		return "member/find";
	}
	
	@RequestMapping(value="findConfirm.go", method=RequestMethod.GET)
	public String findID2() {
		return "member/find2";
	}
	
	@RequestMapping(value = "/member.join.do", method = RequestMethod.POST)
	public String memberJoinDo(Member m,HttpServletRequest req) {
		mDAO.join(m, req);
		return "login";
	}
	
//	@RequestMapping(value="/member.login", method=RequestMethod.POST)
//	public String memberLoginDo(Member m, HttpServletRequest req) {
//		mDAO.login(m, req);
//		mDAO.isLogined(req);
//		req.setAttribute("lp", "member/welcome.jsp");
//		req.setAttribute("cp", "home.jsp");
//		return "index";
//	}
	
	@RequestMapping(value="/member.login", method=RequestMethod.POST)
	public String memberLoginDo(Member m, HttpServletRequest req) {
		mDAO.login(m, req);
		if (mDAO.isLogined(req)) {
			req.setAttribute("cp", "home.jsp");
			req.setAttribute("lp", "member/welcome.jsp");
			return "index";
		} 
		return "login";
	}
	
	
	
	@RequestMapping(value="/member.findid.do", method=RequestMethod.GET)
	public String findIDDo(Member m, HttpServletRequest req) {
		mDAO.findID(m, req);
		return "member/find2";
	}
	
/*	@RequestMapping(value = "/member.logout", method = RequestMethod.GET)
	public String memberLogout(Member m, HttpServletRequest req) {
		mDAO.logout(req);
		return "login";
	}*/
	@RequestMapping(value = "/member.bye", method = RequestMethod.GET)
	public String memberBye(Member m, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
				mDAO.bye(req);
				mDAO.logout(req);
				mDAO.isLogined(req);
		}
		return "login";
	}
	
	@RequestMapping(value = "/member.info", method = RequestMethod.GET)
	public String memberInfo(Member m, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			req.setAttribute("lp", "member/welcome.jsp");
			req.setAttribute("cp", "member/info.jsp");
			return "index";
		} else {
			return "login";
		}
	}
	
	@RequestMapping(value = "/member.info.update", method = RequestMethod.POST)
	public String memberInfoUpdate(Member m, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			mDAO.update(req, m);
			mDAO.isLogined(req);
			req.setAttribute("lp", "member/welcome.jsp");
			req.setAttribute("cp", "home.jsp");
			return "index";
		} else {
			return "login";
		}
	}
}
