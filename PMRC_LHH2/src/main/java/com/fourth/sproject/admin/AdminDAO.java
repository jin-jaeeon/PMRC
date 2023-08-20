package com.fourth.sproject.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fourth.sproject.board.PMRCOptions;
import com.fourth.sproject.member.Member;

@Service
public class AdminDAO {
	// 전체 회원수
			private int allMemberCount;
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
			
			public int getAllMemberCount() {
				return allMemberCount;
				
			}
		public void getMember(int page, HttpServletRequest req) {
			try {
				int memberCount = allMemberCount;
				String search = (String) req.getSession().getAttribute("search");
				if (search == null) {
					search = "";
				} else {
					// 검색어가 있는 상황(search 값에 다른 값이 들어있는 경우) 실행되는 영역
					memberSelector mSel = new memberSelector(search, 0, 0);
					memberCount = ss.getMapper(AdminMapper.class).getMemberCount(mSel);
				}

				int pageCount = (int) Math.ceil(memberCount / (double) po.getPostsPerPage());

				req.setAttribute("dPN", po.getDisplayPageNum());
				int start = (page - 1) * po.getPostsPerPage() + 1;
				int end = page * po.getPostsPerPage();
				
				memberSelector pSel = new memberSelector(search, start, end);
				List<Member> members = ss.getMapper(AdminMapper.class).getMember(pSel);
				req.setAttribute("members", members);
				req.setAttribute("pageCount", pageCount);
				req.setAttribute("page", page);
			} catch (Exception e) {
			}
		}
		
		public void search(String search, HttpServletRequest req) {
			req.getSession().setAttribute("search", search);
		}
	}