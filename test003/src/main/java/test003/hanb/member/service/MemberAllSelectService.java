package test003.hanb.member.service;

import java.util.Map;

import test003.hanb.member.Member;
import test003.hanb.member.dao.MemberDAO;

public class MemberAllSelectService {
	private MemberDAO memberDao;
	
	public MemberAllSelectService(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}
	
	public Map<String, Member> allSelect() {
		return memberDao.getMemberDB();
	}
}
