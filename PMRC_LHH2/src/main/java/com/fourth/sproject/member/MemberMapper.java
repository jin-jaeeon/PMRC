package com.fourth.sproject.member;


public interface MemberMapper {
	public abstract int join(Member m);
	public abstract Member getMemberByID(Member m);
	public abstract Member getMemberByName(Member m);
	public abstract int bye(Member m);
	public abstract int update(Member m);
}
