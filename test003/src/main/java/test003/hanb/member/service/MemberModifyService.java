package test003.hanb.member.service;

import test003.hanb.member.Member;
import test003.hanb.member.dao.MemberDAO;

public class MemberModifyService {
	private MemberDAO memberDao;
	
	public MemberModifyService(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	public void modify(Member member) {
		if(verify(member.getmId())) {
			memberDao.update(member);
		} else {
			System.out.println("수정실패");
		}
	}
	
	public boolean verify(String mId) {
		Member member = memberDao.select(mId);
		return member != null? true : false;
	}
}
