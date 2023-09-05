package test003.hanb.member.service;

import test003.hanb.member.Member;
import test003.hanb.member.dao.MemberDAO;

public class MemberRegisterService {
	private MemberDAO memberDao;

	public MemberRegisterService(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	public void register(Member member) {
		if (verify(member.getmId())) {
			memberDao.insert(member);
		} else {
			System.out.println("이미 가입된 계정입니다.");
		}
	}

	public boolean verify(String mId) {
		Member member = memberDao.select(mId);
		return member == null ? true : false;
	}
}
