package ch06_pjt_01.ems.member.service;

import ch06_pjt_01.ems.member.Student;
import ch06_pjt_01.ems.member.dao.StudentDAO;

public class StudentSelectService {
	private StudentDAO studentDao;

	public StudentSelectService(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}

	public Student select(String sNum) {
		if (verify(sNum)) {
			return studentDao.select(sNum);
		} else {
			System.out.println("Student information is unavailable");
			return null;
		}
	}

	public boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		// 학생 정보가 있으면 true / 없으면 false
		return student != null ? true : false;
	}
}
