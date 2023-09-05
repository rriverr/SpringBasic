package test003.hanb.member.service;

import test003.hanb.member.Member;
import test003.hanb.member.dao.MemberDAO;

public class MemberDeleteService {
	private MemberDAO memberDao;
	
	public MemberDeleteService(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}
	
	public void delete(String mId) {
		if(verify(mId)) {
			memberDao.delete(mId);
		} else {
			System.out.println("삭제실패");
		}
	}
	
	public boolean verify(String mId) {
		Member member = memberDao.select(mId);
		return member != null? true : false;
	}
	
	
}
