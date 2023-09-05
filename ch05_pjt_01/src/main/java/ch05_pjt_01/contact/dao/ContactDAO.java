package ch05_pjt_01.contact.dao;

import java.util.HashMap;
import java.util.Map;

import ch05_pjt_01.contact.ContactSet;


// DataBase 연결.
// Service에 의해서 호출되고, 기능을 수행한다.
public class ContactDAO {
	private Map<String, ContactSet> contactDB = new HashMap<String, ContactSet>();

	public void insert(ContactSet contactSet) {
		contactDB.put(contactSet.getName(), contactSet); // = key : contactSet.getName() - value : contactSet
	}

	public ContactSet select(String name) {
		return contactDB.get(name);
	}

	public Map<String, ContactSet> getContactDB() {
		return contactDB;
	}
	
}
