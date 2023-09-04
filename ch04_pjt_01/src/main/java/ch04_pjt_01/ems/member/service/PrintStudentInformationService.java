package ch04_pjt_01.ems.member.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import ch04_pjt_01.ems.member.Student;

public class PrintStudentInformationService {
	StudentAllSelectService allSelectService;

	public PrintStudentInformationService(StudentAllSelectService allSelectService) {
		this.allSelectService = allSelectService;
	}

	public void printStudentsInfo() {
		Map<String, Student> allStudent = allSelectService.allSelect();
		Set<String> keys = allStudent.keySet();
		Iterator<String> iterator = keys.iterator();
		// Iterator = hashset에 있는 걸 하나하나 뽑아 쓸 수 있게 해주는 거...?
		// https://onlyfor-me-blog.tistory.com/319
		System.out.println("STUDENT LIST STARTS -----");

		while (iterator.hasNext()) {
			String key = iterator.next();
			Student student = allStudent.get(key);
			System.out.print("sNum : " + student.getsNum() + "\t");
			System.out.print("| sId : " + student.getsId() + "\t");
			System.out.print("| sPw : " + student.getsPw() + "\t");
			System.out.print("| sName : " + student.getsName() + "\t");
			System.out.print("| sAge : " + student.getsAge() + "\t");
			System.out.print("| sGender : " + student.getsGender() + "\t");
			System.out.print("| sMajor : " + student.getsMajor() + "\n");
		}
		System.out.println("END --------------------");
	}
}
