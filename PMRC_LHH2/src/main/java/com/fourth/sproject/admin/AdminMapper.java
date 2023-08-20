package com.fourth.sproject.admin;

import java.util.List;

import com.fourth.sproject.member.Member;

public interface AdminMapper {
	public abstract List<Member> getMember(memberSelector ms);
	public abstract int getMemberCount(memberSelector ms);
	public abstract int getPostCountByName(Member m);

}
