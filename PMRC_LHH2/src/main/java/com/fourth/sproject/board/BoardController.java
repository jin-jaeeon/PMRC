package com.fourth.sproject.board;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fourth.sproject.TokenGenerator;
import com.fourth.sproject.member.MemberDAO;


@Controller
public class BoardController {
	@Autowired
	MemberDAO mDAO;
	@Autowired
	BoardDAO bDAO;
	
	@RequestMapping(value="/go.sns" ,method=RequestMethod.GET)
	public String goBoard(HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			bDAO.clearSearch(req);
			bDAO.getPost(1, req);
			
			req.setAttribute("cp", "board/boardJ.jsp");
			return "index";
		}else {
			return "login";
		}
	}
	
	@RequestMapping(value="/go.snsP" ,method=RequestMethod.GET)
	public String goBoardPage(@RequestParam(value="page") int p, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			bDAO.getPost(p, req);
			System.out.println(p);
			req.setAttribute("cp", "board/boardJ.jsp");
			return "index";
		}else {
			return "login";
		}
		
	}
	
	@RequestMapping(value="/post.search", method=RequestMethod.GET)
	public String searchPost(@RequestParam(value="search") String search, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			bDAO.search(search, req);
			bDAO.getPost(1, req);
			req.setAttribute("cp", "board/boardJ.jsp");
			return "index";
		}else {
			return "login";
		}
	}
	
	@RequestMapping(value="/go.boardWrite", method=RequestMethod.GET)
	public String goBoardWrite(HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
//			bDAO.writePost(p, req);
//			bDAO.clearSearch(req);
//			bDAO.getPost(1, req);
//			TokenGenerator.generate(req);
			req.setAttribute("cp", "board/boardWriteH.jsp");
		}else {
			req.setAttribute("lp", "login.jsp");
		}
		return "index";
	}
	@RequestMapping(value="/writePost", method=RequestMethod.POST)
	public String writePost(@RequestParam(value="pb_writer") String pb_writer, Post p, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			bDAO.writePost(p, req);
			TokenGenerator.generate(req);
			bDAO.getLastPost(pb_writer, req);
			req.setAttribute("cp", "board/boardDetailH.jsp");
			return "index";
		}else {
			return "login";
		}
	}
	
	@RequestMapping(value = "/delete.post", method = RequestMethod.GET)
	public String deletePost(Post p, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			bDAO.deletePost(p, req);
			TokenGenerator.generate(req);
			bDAO.getPost(1, req);
			req.setAttribute("cp", "board/boardJ.jsp");
			return "index";
		} else {
			return "login";
		}
	}
	
	@RequestMapping(value="/goPost" ,method=RequestMethod.GET)
	public String goPost(@RequestParam("pageDetail") BigDecimal pageDetail, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			bDAO.addClickCount(pageDetail, req);
			bDAO.getPostDetailH(pageDetail, req);
			bDAO.getReplyH(pageDetail, req);
			req.setAttribute("cp", "board/boardDetailH.jsp");
			return "index";
		}else {
			return "login";
		}
	}

	@RequestMapping(value="/go.updatePost" ,method=RequestMethod.GET)
	public String goUpdatePost(@RequestParam("pageDetail") BigDecimal pageDetail, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			bDAO.getPostDetailH(pageDetail, req);
			bDAO.getReplyH(pageDetail, req);
			req.setAttribute("cp", "board/boardUpdateHH.jsp");
			return "index";
		}else {
			return "login";
		}
	}
	
	@RequestMapping(value="/updatePost", method=RequestMethod.POST)
	public String updatePost(@RequestParam("pb_no") BigDecimal pb_no, Post p, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			bDAO.updatePost(p, req);
			bDAO.getPostDetailH(pb_no, req);
			bDAO.getReplyH(pb_no, req);
			req.setAttribute("cp", "board/boardDetailH.jsp");
			return "index";
		}else {
			return "login";
		} 
	}
	
	/*@RequestMapping(value = "/go.post/write", method = RequestMethod.POST)
	public String snsReplyWrite(PostReply pr, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			bDAO.writeReply(pr, req);
			TokenGenerator.generate(req);
			req.setAttribute("cp", "board/boardDetailH.jsp");
		} else {
			req.setAttribute("cp", "home.jsp");
		}
		return "index";
	}*/
	
}