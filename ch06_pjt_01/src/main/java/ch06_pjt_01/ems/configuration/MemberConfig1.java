package ch06_pjt_01.ems.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch06_pjt_01.ems.member.dao.StudentDAO;
import ch06_pjt_01.ems.member.service.PrintStudentInformationService;
import ch06_pjt_01.ems.member.service.StudentAllSelectService;
import ch06_pjt_01.ems.member.service.StudentDeleteService;
import ch06_pjt_01.ems.member.service.StudentModifyService;
import ch06_pjt_01.ems.member.service.StudentRegisterService;
import ch06_pjt_01.ems.member.service.StudentSelectService;
import ch06_pjt_01.ems.utils.InitSampleData;

@Configuration
public class MemberConfig1 {

	@Bean
	public StudentDAO studentDAO() {
		// return 하고 있는 StudentDAO객체가 Bean으로 등록
		// <bean id="studentDAO class="ch06_pjt_01.ems.member.dao.StudentDAO" /> 와 동일하다.
		// bean id = 메서드 이름
		// bean class = 메서드의 return 타입
		return new StudentDAO();
	}

	@Bean
	public StudentRegisterService studentRegisterService() {
		// xml로 작성했던 <constructor-arg ref="StudentDAO"/> = studentDAO()
		// studentDAO() 메서드를 실행해서 studentDAO bean 객체를 받는다.
		return new StudentRegisterService(studentDAO());
	}

	@Bean
	public StudentModifyService studentModifyService() {
		return new StudentModifyService(studentDAO());
	}

	@Bean
	public StudentDeleteService studentDeleteService() {
		return new StudentDeleteService(studentDAO());
	}

	@Bean
	public StudentSelectService studentSelectService() {
		return new StudentSelectService(studentDAO());
	}

	@Bean
	public StudentAllSelectService studentAllSelectService() {
		return new StudentAllSelectService(studentDAO());
	}

	@Bean
	public PrintStudentInformationService printStudentInformationService() {
		return new PrintStudentInformationService(studentAllSelectService());
	}

	@Bean
	public InitSampleData initSampleData() {
		InitSampleData initSampleData = new InitSampleData();
		String[] sNums = { "hbs001", "hbs002", "hbs003", "hbs004", "hbs005", };
		initSampleData.setsNums(sNums);
		String[] sIds = { "rabbit", "hippo", "raccoon", "elephant", "lion", };
		initSampleData.setsIds(sIds);
		String[] sPws = { "96539", "64875", "15284", "48765", "28661", };
		initSampleData.setsPws(sPws);
		String[] sNames = { "agatha", "barbara", "chris", "doris", "elva" };
		initSampleData.setsNames(sNames);
		int[] sAges = { 19, 22, 20, 27, 19 };
		initSampleData.setsAges(sAges);
		char[] sGenders = { 'M', 'W', 'W', 'M', 'M' };
		initSampleData.setsGenders(sGenders);
		String[] sMajors = { "English Literature", "Korean Language and Literature", "French Language and Literature",
				"Philosophy", "History", };
		initSampleData.setsMajors(sMajors);

		return initSampleData;
	}
}
