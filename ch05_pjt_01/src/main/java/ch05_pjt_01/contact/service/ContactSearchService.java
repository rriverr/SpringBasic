package ch05_pjt_01.contact.service;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import ch05_pjt_01.contact.ContactSet;
import ch05_pjt_01.contact.dao.ContactDAO;

// 특정 연락처의 정보를 얻는 class 
// 역시 생성자에서 DAO를 받아 초기화 후 사용한다 
public class ContactSearchService {
//	@Autowired
	@Inject
	private ContactDAO contactDao;

	public ContactSearchService() {
		System.out.println("default constructor");
	}

//	@Autowired
	@Inject
	public ContactSearchService(ContactDAO contactDao) {
		System.out.println("contactDAO-search : " + contactDao);
		this.contactDao = contactDao;
	}

	public ContactSet searchContact(String name) {
		if (verify(name)) {
			return contactDao.select(name);
		} else {
			System.out.println("Contact information is no available");
			return null;
		}
	}

	public boolean verify(String name) {
		ContactSet contactSet = contactDao.select(name);
		return contactSet != null ? true : false;
	}

//	@Autowired
	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDao = contactDAO;
	}
}
