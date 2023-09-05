package test003.hanb.member.service;

import test003.hanb.member.Member;
import test003.hanb.member.dao.MemberDAO;

public class MemberSelectService {
	private MemberDAO memberDao;

	public MemberSelectService(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	public Member select(String mId) {
		if (verify(mId)) {
			return memberDao.select(mId);
		} else {
			System.out.println("조회 실패");
			return null;
		}
	}

	public boolean verify(String mId) {
		Member member = memberDao.select(mId);
		return member != null ? true : false;
	}
}
