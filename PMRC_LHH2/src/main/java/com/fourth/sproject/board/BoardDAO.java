package com.fourth.sproject.board;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BoardDAO {
	// 전체 게시글 수
	private int allPostCount;
	// 현재 페이지 번호
	private int currentPage;
	
	@Autowired
	private PMRCOptions po;
	@Autowired
	private SqlSession ss;
	
	public void clearSearch(HttpServletRequest req) {
		// 세션의 search 어트리뷰트에 null값 할당
		req.getSession().setAttribute("search", null);
	}
	
	public int getAllPostCount() {
		return allPostCount;
		
	}
	
	public void addClickCount(BigDecimal pageDetail, HttpServletRequest req) {
		try {
			ss.getMapper(BoardMapper.class).addClickCount(pageDetail);
			System.out.println("성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getPost(int page, HttpServletRequest req) {
		try {
			// 전체 게시글 수 저장
			int postCount = allPostCount;
			// null값 불러오기(처음 게시판에 접속했을 때)
			// search 어트리뷰트에 할당되어있는(검색어) 문자열 가져오기
			String search = (String) req.getSession().getAttribute("search");
			if (search == null) {
				// 검색어가 없는 상황에서(처음 게시판에 접속했을 때) 실행되는 영역
				// search에 빈 문자열 저장
				search = "";
			} else {
				// 검색어가 있는 상황(search 값에 다른 값이 들어있는 경우) 실행되는 영역
				// 저장되어있는 search값으로 초기화하고, start, end에 0으로 초기화
				PostSelector pSel2 = new PostSelector(search, 0, 0);
				// 검색어가 들어간 제목,작성자 글 조회하여 전체 결과 수 저장
				postCount = ss.getMapper(BoardMapper.class).getPostCount(pSel2);
			}
			// bo는 servlet-context.xml에서 bean으로 저장해놨기 때문에 스프링이 실행될 때 각각 10으로 초기화 되어있음 
			// 페이지 개수는 쿼리문을 수행한 전체 게시글 결과수를 10으로 나누고 올림한 정수값을 저장
			System.out.println("postsperpage:"+po.getPostsPerPage());
			int pageCount = (int) Math.ceil(postCount / (double) po.getPostsPerPage());
			System.out.println("pagecount:"+pageCount);
			System.out.println("allpostscount:"+allPostCount);
			req.setAttribute("dPN", po.getDisplayPageNum());
//			System.out.println("전체페이지 수 :" + postCount);
			// start에 1 
			int start = (page - 1) * po.getPostsPerPage() + 1;
			// end에 10
			int end = page * po.getPostsPerPage();
			// 검색어와 start, end값 초기화
			PostSelector pSel = new PostSelector(search, start, end);
			// 게시글 정보를 담은 리스트 생성
			List<Post> posts = ss.getMapper(BoardMapper.class).getPost(pSel);
			req.setAttribute("posts", posts);
			req.setAttribute("pageCount", pageCount);
			req.setAttribute("page", page);
		} catch (Exception e) {
		}
	}
	
	public void getPageNum(HttpServletRequest req) {
		// 전체 게시글 수 = allPostCount
		// 한 페이지당 표시 게시글 개수 = postsPerPage
		// 총 페이지 개수 = pageCount
		
	}
	
	public void search(String search, HttpServletRequest req) {
		req.getSession().setAttribute("search", search);
	}
	
	public void setAllPostCount() {
		//search, start, end 초기화
		PostSelector sSel = new PostSelector("", 0, 0);
		// db통신 -> 검색어가 들어간 작성자 or 글 숫자 조회해서 초기화(int) -> 결과적으로 전체 작성글 수가 저장됨
		allPostCount = ss.getMapper(BoardMapper.class).getPostCount(sSel);
		System.out.println("allpostcount:"+allPostCount);
	}
	
	public void setAllPostCount(int allPostCount) {
		this.allPostCount = allPostCount;
	}
	
	public void writePost(Post p, HttpServletRequest req) {
		ss.getMapper(BoardMapper.class).writePost(p);
		allPostCount++;
		
	}

	public void getLastPost(String pb_writer, HttpServletRequest req) {
		LastPostDetailHH pdd = new LastPostDetailHH(pb_writer);
		List<Post> postDetails = ss.getMapper(BoardMapper.class).getLastPost(pdd);
		req.setAttribute("postDetail", postDetails);
		
	}
	
	public void getPostDetailH(BigDecimal pageDetail, HttpServletRequest req) {
		PostDetailH PD = new PostDetailH(pageDetail);
		List<Post> postDetails = ss.getMapper(BoardMapper.class).getDetailByID(PD);
		req.setAttribute("postDetail", postDetails);
		
	}
	public void getReplyH(BigDecimal pageDetail, HttpServletRequest req) {
		
		PostDetailH PD = new PostDetailH(pageDetail);
		List<PostReply> postReply = ss.getMapper(BoardMapper.class).getPostReplyH(PD);
		req.setAttribute("postReply", postReply);
		
		
	}
	public void deletePost(Post p, HttpServletRequest req) {
		try {
			if (ss.getMapper(BoardMapper.class).deletePost(p)==1) {
				req.setAttribute("result", "삭제성공");
				allPostCount--;
				
			} else {
				req.setAttribute("result", "삭제실패");
				
			}
		} catch (Exception e) {
			req.setAttribute("result", "삭제실패[애초에]");
			e.printStackTrace();
		}
		
	}
	public void updatePost(Post p, HttpServletRequest req) {
		try {
			if (ss.getMapper(BoardMapper.class).update(p)==1) {
				req.setAttribute("result", "수정 성공");
				
			} else {
				req.setAttribute("result", "수정 실패");
				
			}
		} catch (Exception e) {
			req.setAttribute("result", "수정 실패[애초에]");
			e.printStackTrace();
		}
		
	}

		
	public void writeReply(PostReply pr, HttpServletRequest req) {
		try {
			String token = req.getParameter("token");
			String LastSuccessToken = (String) req.getSession().getAttribute("successToken");
			if (LastSuccessToken != null && token.equals(LastSuccessToken)) {
				req.setAttribute("result", "글쓰기 실패(새로고침)");
				return;
			}
			
			pr.setPsr_txt(pr.getPsr_txt().replace("\r\n", "<br>"));
			if (ss.getMapper(BoardMapper.class).writeReply(pr)==1) {
				req.setAttribute("result", "댓글 쓰기 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "댓글 쓰기 실패");
		}
		
		
	}
	
}

