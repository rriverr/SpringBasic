package ch06_pjt_01.ems.member.service;

import ch06_pjt_01.ems.member.Student;
import ch06_pjt_01.ems.member.dao.StudentDAO;

public class StudentRegisterService {
	private StudentDAO studentDao;

	public StudentRegisterService(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}

	public void register(Student student) {
		if (verify(student.getsNum())) {
			studentDao.insert(student);
		} else {
			System.out.println("The student has already been registered");
		}
	}

	public boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		// 학생 정보가 있으면 false / 있으면 true 
		return student == null ? true : false;
	}
}
