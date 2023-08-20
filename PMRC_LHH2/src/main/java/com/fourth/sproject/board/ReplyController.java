package com.fourth.sproject.board;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fourth.sproject.TokenGenerator;
import com.fourth.sproject.member.MemberDAO;


@Controller
@RequestMapping("/go.post/*")
public class ReplyController {
	
	@Autowired
	MemberDAO mDAO;
	
	@Autowired
	BoardDAO bDAO;
	
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String snsReplyWrite(PostReply pr, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			bDAO.writeReply(pr, req);
			String p = req.getParameter("psr_ps_no");
			TokenGenerator.generate(req);
			return "redirect:/goPost?pageDetail="+p;
		} else {
			req.setAttribute("cp", "home.jsp");
		}
		return "index";
	}
	
}