package ch06_pjt_01.ems.member.service;

import ch06_pjt_01.ems.member.Student;
import ch06_pjt_01.ems.member.dao.StudentDAO;

public class StudentModifyService {
	private StudentDAO studentDao;

	public StudentModifyService(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}

	public void modify(Student student) {
		if (verify(student.getsNum())) {
			studentDao.update(student);
		} else {
			System.out.println("Student information is unavailable.");
		}
	}

	public boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		// 학생 정보가 있으면 true / 없으면 false
		return student != null ? true : false;
	}
}
