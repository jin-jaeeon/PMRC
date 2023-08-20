package com.fourth.sproject.board;

import java.math.BigDecimal;
import java.util.List;

import com.fourth.sproject.member.Member;

public interface BoardMapper {
	public abstract List<Post> getPost(PostSelector ps);
	public abstract int getPostCount(PostSelector ps);
	public abstract int getPostCountByWriter(Member m);
	public abstract void addClickCount(BigDecimal pageDetail);
	public abstract int writePost(Post p);
	public abstract int deletePost(Post p);
	public abstract List<Post> getDetailByID(PostDetailH PD);
	public abstract List<Post> getLastPost(LastPostDetailHH pdd);
	public abstract int update(Post p);
	
	public abstract List<PostReply> getPostReplyH(PostDetailH PD);
	public abstract int writeReply(PostReply pr);

}
