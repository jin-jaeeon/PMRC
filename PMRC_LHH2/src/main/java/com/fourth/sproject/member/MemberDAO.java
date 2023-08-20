package com.fourth.sproject.member;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fourth.sproject.board.BoardDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class MemberDAO {
	@Autowired
	private SqlSession ss;
	@Autowired 
	private BoardDAO bDAO;
	
	public void findID(Member m, HttpServletRequest req) {
		try {
			Member dbMember = ss.getMapper(MemberMapper.class).getMemberByName(m);
			if (dbMember!=null) {
				if (m.getP_name().equals(dbMember.getP_name())) {
					req.setAttribute("ID", dbMember.getP_user());
				}
			}else {
				req.setAttribute("ID", "가입된 ID가 없습니다.");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("여기");
		}
	}
	
	public void login(Member m, HttpServletRequest req) {
		try {
			Member dbMember = ss.getMapper(MemberMapper.class).getMemberByID(m);
			if (dbMember != null) {
				if (m.getP_password().equals(dbMember.getP_password())) {
					req.getSession().setAttribute("loginMember", dbMember);
					req.getSession().setMaxInactiveInterval(600);
					bDAO.setAllPostCount();
				}else {
					req.setAttribute("result", "로그인 실패[pw]");
				}
			}else {
				req.setAttribute("result", "로그인실패[미가입 ID]");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("로그인 실패(db)");
		}
	}
	
	public boolean isLogined(HttpServletRequest req) {
		if (req.getSession().getAttribute("loginMember")!=null) {
			req.setAttribute("lp", "member/welcome.jsp");
			req.setAttribute("cp", "home.jsp");
			return true;
		}
		return false;
	}
	
	public void join(Member m, HttpServletRequest req) {
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		System.out.println(path);
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(req, path, 10485760, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("result", "가입실패(프사)");
			System.out.println("가입 실패(프사)");
			return;
		}
		try {
			m.setP_user(mr.getParameter("p_user"));
			m.setP_password(mr.getParameter("p_password"));
			m.setP_name(mr.getParameter("p_name"));
			m.setP_grade("false");
			String yy = mr.getParameter("p_y");
			int mm = Integer.parseInt(mr.getParameter("p_m")); // 1
			int dd = Integer.parseInt(mr.getParameter("p_d")); // 13
			String bd = String.format("%s%02d%02d", yy, mm, dd); // "19990113"
			Date p_birthday = new SimpleDateFormat("yyyyMMdd").parse(bd);
			m.setP_birthday(p_birthday);

			String p_photo = mr.getFilesystemName("p_photo"); // ㅋ ㅋ.png
			p_photo = URLEncoder.encode(p_photo, "utf-8"); // %2A+%2A.png
			p_photo = p_photo.replace("+", " "); // %2A %2A.png
			m.setP_photo(p_photo);
			if (ss.getMapper(MemberMapper.class).join(m) == 1) {
				req.setAttribute("result", "가입성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "가입실패");
			new File(path + "/" + mr.getFilesystemName("p_photo")).delete();
		}
		
	}
	
	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("loginMember", null);
	}
	
	public void bye(HttpServletRequest req) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");

		// 추후에 SNS게시판 만들면 연동시켜서 삭제해야하므로
		//	int allPostCount = sDAO.getAllPostCount();
		//	int postCount = ss.getMapper(SnsMapper.class).getPostCountByWriter(m);
		
			if (ss.getMapper(MemberMapper.class).bye(m)==1) {
				req.setAttribute("result", "탈퇴성공");
				
			// 쓴 게시글 수 만큼 전체 갯수에서 까줘야함(다시 countall 하기에는 DB에 무리를 주기에)
			//	sDAO.setAllPostCount(allPostCount-postCount);
				
				// 프사 파일 삭제해야함
				String folder = req.getSession().getServletContext().getRealPath("resources/img");
				String file = URLDecoder.decode(m.getP_photo(), "utf-8");
				File f = new File(folder + "/" + file);
				f.delete();
			} else {
				req.setAttribute("result", "탈퇴실패");
				
			}
		} catch (Exception e) {
			req.setAttribute("result", "탈퇴실패");
			e.printStackTrace();
		}
		
	}

	public void update(HttpServletRequest req, Member m) {
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(req, path, 10485760, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("result", "정보수정실패[error:용량]");
			return;
		}

		m = (Member) req.getSession().getAttribute("loginMember");
		String oldFile = null;
		String newFile = null;
		try {
			m.setP_password(mr.getParameter("p_password"));
					
			oldFile = m.getP_photo();
			newFile = mr.getFilesystemName("p_photo");

			// 프사 안 바꾸는 사람
			if (newFile == null) {
				newFile = oldFile;

			// 프사 바꾸는 사람이 10mb 이하 선택했을때
			} else { 
				newFile = URLEncoder.encode(newFile, "utf-8");
				newFile = newFile.replace("+", " ");
			}
				m.setP_photo(newFile);
				
			if (ss.getMapper(MemberMapper.class).update(m)==1) {
				req.setAttribute("result", "정보수정 성공");
				if (!oldFile.equals(newFile)) {
					oldFile = URLDecoder.decode(oldFile, "utf-8");
					new File(path + "/" + oldFile).delete();
				}
					
				Member dbMember = ss.getMapper(MemberMapper.class).getMemberByID(m);
				req.getSession().setAttribute("loginMember", dbMember);
				
			} else {
				req.setAttribute("result", "정보수정실패");
				if (!oldFile.equals(newFile)) {
					newFile = URLDecoder.decode(newFile, "utf-8");
					new File(path + "/" + newFile).delete();
				}
			}
		} catch (Exception e) {
			req.setAttribute("result", "정보수정실패[DB]");
			if (!oldFile.equals(newFile)) {
				try {
					newFile = URLDecoder.decode(newFile, "utf-8");
					new File(path + "/" + newFile).delete();
				} catch (UnsupportedEncodingException e1) {
					e.printStackTrace();
					
				
				} 
			}
		}
	}
}
