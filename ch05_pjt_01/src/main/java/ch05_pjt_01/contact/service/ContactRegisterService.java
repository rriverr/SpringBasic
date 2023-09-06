package ch05_pjt_01.contact.service;

import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ch05_pjt_01.contact.ContactSet;
import ch05_pjt_01.contact.dao.ContactDAO;

// 연락처 정보를 DataBase(이 프로젝트에선 hashmap)에 저장하는 기능
// 생성자에서 DAO를 받아 초기화한다. -> 추후 IoC 컨테이너에서 생성자에 ContactDAO를 주입하게 된다(뭔소리임?)

public class ContactRegisterService {

	// xml에서 context:annotation-config를 하지 않아도 
	// 이렇게 필드에 autowired를 명시하면 자동 주입을 할 수 있다. 
	// 매개변수를 명시해놓지 않은 기본 생성자에도 자동 주입이 됨. 
	// Autowired 하면 자동으로 bean 등록까지 된다. 
//	@Resource
//	@Qualifier("usedDAO")
//	@Autowired 
//	@Autowired(required=false)
	@Inject
	@Named("contactDao")
	private ContactDAO contactDao;
	
//	@Autowired
//	@Resource
//	@Inject
//	@Named("contactDao")
	public ContactRegisterService(ContactDAO contactDao) {
		System.out.println("contactDAO-register : " + contactDao);
		this.contactDao = contactDao;
	}
	

	
	public void register(ContactSet contactSet) {
		String name = contactSet.getName();
		if(verify(name)) {
			contactDao.insert(contactSet);
		} else {
			System.out.println("The name has already registered.");
		}
	}
	
	// name을 통해 기존에 등록된 연락처를 검색하여 중복 여부를 판단한다. 
	public boolean verify(String name) {
		ContactSet contactSet = contactDao.select(name);
		return contactSet == null ? true : false;
	}
	
	public void setWordDao(ContactDAO contactDao) {
		this.contactDao = contactDao;
	}
	
//	@Autowired
//	@Resource
	@Inject
	@Named("contactDao")
	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDao = contactDAO; 
	}
	
}
