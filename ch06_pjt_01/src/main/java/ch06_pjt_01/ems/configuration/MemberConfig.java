package ch06_pjt_01.ems.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch06_pjt_01.ems.member.DBConnectionInfo;
import ch06_pjt_01.ems.member.dao.StudentDAO;
import ch06_pjt_01.ems.member.service.EMSInformationService;
import ch06_pjt_01.ems.member.service.PrintStudentInformationService;
import ch06_pjt_01.ems.member.service.StudentAllSelectService;
import ch06_pjt_01.ems.member.service.StudentDeleteService;
import ch06_pjt_01.ems.member.service.StudentModifyService;
import ch06_pjt_01.ems.member.service.StudentRegisterService;
import ch06_pjt_01.ems.member.service.StudentSelectService;
import ch06_pjt_01.ems.utils.InitSampleData;

@Configuration
public class MemberConfig {

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
	public DBConnectionInfo dev_DBConnectionInfoDev() {
		DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();
		dbConnectionInfo.setUrl("000.000.000.000");
		dbConnectionInfo.setUserId("admin");
		dbConnectionInfo.setUserPw("0000");

		return dbConnectionInfo;
	}

	@Bean
	public DBConnectionInfo real_DBConnectionInfoDev() {
		DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();
		dbConnectionInfo.setUrl("111.111.111.111");
		dbConnectionInfo.setUserId("master");
		dbConnectionInfo.setUserPw("1111");

		return dbConnectionInfo;
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

	@Bean
	public EMSInformationService EMSInformation() {
		EMSInformationService emsInformationService = new EMSInformationService();
		emsInformationService.setInfo("Education Management System program was developed in 2022");
		emsInformationService.setCopyRight(
				"COPYRIGHT(C) 2022 EMS CO,. LTD ALL RIGHT RESERVED. CONTACT MASTER FOR MORE INFORMATION.");
		emsInformationService.setVer("The version is 1.0");
		emsInformationService.setsMonth(3);
		emsInformationService.setsDay(1);
		emsInformationService.seteYear(2022);
		emsInformationService.seteMonth(4);
		emsInformationService.setsDay(30);

		List<String> developers = new ArrayList<String>();
		developers.add("Cheney");
		developers.add("Eloy");
		developers.add("Jasper");
		developers.add("Dillon");
		developers.add("Kian");
		emsInformationService.setDevelopers(developers);

		Map<String, DBConnectionInfo> dbInfos = new HashMap<String, DBConnectionInfo>();
		dbInfos.put("dev", dev_DBConnectionInfoDev());
		dbInfos.put("real", real_DBConnectionInfoDev());
		emsInformationService.setDbInfors(dbInfos);

		return emsInformationService;
	}

}
