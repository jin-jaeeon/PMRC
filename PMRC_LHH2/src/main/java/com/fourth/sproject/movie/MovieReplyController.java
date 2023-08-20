package com.fourth.sproject.movie;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fourth.sproject.TokenGenerator;
import com.fourth.sproject.member.MemberDAO;

@Controller
@RequestMapping("/goMovie/*")
public class MovieReplyController {

	@Autowired
	MovieDAO moDAO;
	
	@Autowired
	MemberDAO mDAO;
	

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String movieReplyWrite(MovieReply mr, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			moDAO.writeReply(mr, req);
			TokenGenerator.generate(req);
			
			String p = req.getParameter("pmr_pm_code");
			return "redirect:/goMovie?pageDetail="+p;
			
			
		} else {
			req.setAttribute("cp", "home.jsp");
		}
		return "index";
	}
	
}
