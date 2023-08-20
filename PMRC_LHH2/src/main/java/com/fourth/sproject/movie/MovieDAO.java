package com.fourth.sproject.movie;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fourth.sproject.board.BoardMapper;
import com.fourth.sproject.board.PostReply;


@Service
public class MovieDAO {
	
	// 전체 게시글 수
		private int allPostCount;
		// 현재 페이지 번호
		private int currentPage;
		
	@Autowired
	private SqlSession ss;
	@Autowired
	private PMRCMOptions bpo;

	public void search(String search, HttpServletRequest req) {
		req.getSession().setAttribute("search", search); // 검색어 
		/*MovieSelector MS = new MovieSelector(search);
		List<Movie> movies = ss.getMapper(MovieMapper.class).getMovieByID(MS);
		req.setAttribute("Movies", movies);*/
	}
	
	public void getMovieDetailH(String p, HttpServletRequest req) {
			MovieDetailSelector MDS = new MovieDetailSelector(p);
			List<Movie> movieDetails = ss.getMapper(MovieMapper.class).getMovieByCode(MDS);
			List<MovieReply> movieReply = ss.getMapper(MovieMapper.class).getMovieReply(MDS);
			req.setAttribute("movieDetail", movieDetails);
			req.setAttribute("movieReply", movieReply);
			
	}
	
	public void getMovie(int page, HttpServletRequest req) {
		try {
			int postCount = allPostCount;
			String search = (String) req.getSession().getAttribute("search");
			if (search == null) {
				search = "";
			} else {
				MovieSelector pSel2 = new MovieSelector(search, 0, 0);
				postCount = ss.getMapper(MovieMapper.class).getMovieCount(pSel2);
				req.setAttribute("searchCount", postCount);
			}
			int totalMovie = ss.getMapper(MovieMapper.class).getAllMovieCount();
			int pageCount = (int) Math.ceil(postCount / (double) bpo.getPostsPerPage());
			req.setAttribute("dPN", bpo.getDisplayPageNum());
			// start에 1 
			int start = (page - 1) * bpo.getPostsPerPage() + 1;
			// end에 10
			int end = page * bpo.getPostsPerPage();
			// 검색어와 start, end값 초기화
			MovieSelector pSel = new MovieSelector(search, start, end);
			// 게시글 정보를 담은 리스트 생성
			List<Movie> movies = ss.getMapper(MovieMapper.class).getMovie(pSel);
			System.out.println(movies);
			req.setAttribute("MovieCount", totalMovie);
			req.setAttribute("Movies", movies);
			req.setAttribute("pageCount", pageCount);
			req.setAttribute("page", page);
		} catch (Exception e) {
		}
	}
	
	public void writeReply(MovieReply mr, HttpServletRequest req) {
		try {
			String token = req.getParameter("token");
			String LastSuccessToken = (String) req.getSession().getAttribute("successToken");
			if (LastSuccessToken != null && token.equals(LastSuccessToken)) {
				req.setAttribute("result", "댓글쓰기 실패(새로고침)");
				return;
			}
			mr.setPmr_txt(mr.getPmr_txt().replace("\r\n", "<br>"));
			if (ss.getMapper(MovieMapper.class).writeReply(mr)==1) {
				req.setAttribute("result", "댓글 쓰기 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "댓글 쓰기 실패");
		}
		
		
	}
	public void get(HttpServletRequest req) {
		req.setAttribute("movies", ss.getMapper(MovieMapper.class).get());
	}
	
	public Movies getXML() {
		List<Movie> movies = ss.getMapper(MovieMapper.class).get();
		return new Movies(movies);
	}
	
	public Movies searchXML(Movie m) {
		return new Movies(ss.getMapper(MovieMapper.class).search(m));
	}
}
