package ch06_pjt_01.ems.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch06_pjt_01.ems.member.DBConnectionInfo;
import ch06_pjt_01.ems.member.service.EMSInformationService;

@Configuration
public class MemberConfig3 {
	
	// 해당 config파일에 없는 객체, 메서드는 외부에서 주입을 해오면 된다. 
	// (MemberConfig.java랑 비교)
	@Autowired
	DBConnectionInfo dev_DBConnectionInfoDev;
	@Autowired
	DBConnectionInfo real_DBConnectionInfoDev;
	
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
		dbInfos.put("dev", dev_DBConnectionInfoDev);
		dbInfos.put("real", real_DBConnectionInfoDev);
		emsInformationService.setDbInfors(dbInfos);

		return emsInformationService;
	}

}
