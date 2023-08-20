package com.fourth.sproject.movie;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fourth.sproject.member.MemberDAO;

@Controller
public class MovieController {
	
	@Autowired
	MovieDAO moDAO;
	
	@Autowired
	MemberDAO mDAO;
	
	@RequestMapping(value = "go.movie", method = RequestMethod.GET)
	public String goMovie(HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			moDAO.search("", req);
			moDAO.getMovie(1, req);
			req.setAttribute("cp", "movie/movieInfo.jsp");
			return "index";
		}
		return "login";
	}

	@RequestMapping(value = "movie.search", method = RequestMethod.GET)
	public String movieSearch(@RequestParam(value = "search") String search, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			moDAO.search(search, req);
			moDAO.getMovie(1, req);
			req.setAttribute("cp", "movie/movieInfo.jsp");
			return "index";
		}else {
			return "login";
		}
	}

	@RequestMapping(value = "movie.searchP", method = RequestMethod.GET)
	public String movieSearch(@RequestParam(value = "page") int p, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			moDAO.getMovie(p, req);
			req.setAttribute("cp", "movie/movieInfo.jsp");
			return "index";
		}else {
			return "login";
		}
	}
	@RequestMapping(value="/goMovie" ,method=RequestMethod.GET)
    public String goMovie(@RequestParam("pageDetail") String pageDetail, HttpServletRequest req, Movie m) {
        if (mDAO.isLogined(req)) {
            moDAO.getMovieDetailH(pageDetail, req);
            //bDAO.getReplyH(pageDetail, req);
            req.setAttribute("cp", "movie/movieDetailH.jsp");
            return "index";
        }else {
            return "login";
        }
    }
	@RequestMapping(value = "/movie.get", 
			method = RequestMethod.GET, 
			produces = "application/xml; charset=utf-8")
	public @ResponseBody Movies movieGet() {
		return moDAO.getXML();
	}
	
	@RequestMapping(value = "/movie.search2", 
			method = RequestMethod.GET, 
			produces = "application/xml; charset=utf-8")
	public @ResponseBody Movies movieSearch(Movie m) {
		return moDAO.searchXML(m);
	}
	
	@RequestMapping(value = "/go.genre", method = RequestMethod.GET)
	public String getGenreTop10(Movie m, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			moDAO.get(req);
			req.setAttribute("cp", "movie/genreH.jsp");
			return "index";
		} else {
			return "login";
		}
	}
	
}
