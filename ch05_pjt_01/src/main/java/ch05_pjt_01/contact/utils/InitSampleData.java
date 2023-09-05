package ch05_pjt_01.contact.utils;

// context.xml 통해서 주입할거니까 필드 생성만 한다. 
public class InitSampleData {
	private String[] names;
	private String[] phoneNumbers;
	
	public String[] getNames() {
		return names;
	}
	public void setNames(String[] names) {
		this.names = names;
	}
	public String[] getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(String[] phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
}
