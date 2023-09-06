package ch06_pjt_01.ems;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import ch06_pjt_01.ems.configuration.MemberConfig;
import ch06_pjt_01.ems.configuration.MemberConfig1;
import ch06_pjt_01.ems.configuration.MemberConfig2;
import ch06_pjt_01.ems.configuration.MemberConfig3;
import ch06_pjt_01.ems.configuration.MemberConfigImport;
import ch06_pjt_01.ems.member.Student;
import ch06_pjt_01.ems.member.service.EMSInformationService;
import ch06_pjt_01.ems.member.service.PrintStudentInformationService;
import ch06_pjt_01.ems.member.service.StudentDeleteService;
import ch06_pjt_01.ems.member.service.StudentModifyService;
import ch06_pjt_01.ems.member.service.StudentRegisterService;
import ch06_pjt_01.ems.member.service.StudentSelectService;
import ch06_pjt_01.ems.utils.InitSampleData;

public class MainClass {
	public static void main(String[] args) {
////		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
//		String[] appCtxs = { "classpath:appCtx1.xml", "classpath:appCtx2.xml", "classpath:appCtx3.xml" };
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(appCtxs);

//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MemberConfig.class);
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MemberConfig1.class, MemberConfig2.class, MemberConfig3.class);
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MemberConfigImport.class);
		
		InitSampleData initSampleData = ctx.getBean("initSampleData", InitSampleData.class);
		String[] sNums = initSampleData.getsNums();
		String[] sIds = initSampleData.getsIds();
		String[] sPws = initSampleData.getsPws();
		String[] sNames = initSampleData.getsNames();
		int[] sAges = initSampleData.getsAges();
		char[] sGenders = initSampleData.getsGenders();
		String[] sMajors = initSampleData.getsMajors();

		// 학생 정보 등록
		// xml파일에서 주입해준 정보들(initSampleData)을 가져와서 하나하나 register 해줌.
		System.out.println("----------주입했던 학생 정보 register");
		StudentRegisterService registerService = ctx.getBean("studentRegisterService", StudentRegisterService.class);
		for (int i = 0; i < sNums.length; i++) {
			registerService
					.register(new Student(sNums[i], sIds[i], sPws[i], sNames[i], sAges[i], sGenders[i], sMajors[i]));
		}

		PrintStudentInformationService printStudentInformationService = ctx.getBean("printStudentInformationService",
				PrintStudentInformationService.class);
		printStudentInformationService.printStudentsInfo();

		// 새로운 학생 정보 등록
		// getBean 하는 과정 굳이 다시 안 해도 괜찮긴 한데 코드 구분을 위해... 굳이 한다...?
		System.out.println("----------새로운 학생 추가");
		registerService = ctx.getBean("studentRegisterService", StudentRegisterService.class);
		registerService.register(new Student("hbs006", "deer", "p0006", "mellisa", 26, 'W', "Music"));

		printStudentInformationService.printStudentsInfo();

		// 특정 학생 선택 조회
		System.out.println("----------특정 학생 선택 조회");
		StudentSelectService selectService = ctx.getBean("studentSelectService", StudentSelectService.class);
		Student selectedStudent = selectService.select("hbs006");
		System.out.println("STUDENT LIST STARTS -----");
		System.out.print("sNum : " + selectedStudent.getsNum() + "\t");
		System.out.print("| sId : " + selectedStudent.getsId() + "\t");
		System.out.print("| sPw : " + selectedStudent.getsPw() + "\t");
		System.out.print("| sName : " + selectedStudent.getsName() + "\t");
		System.out.print("| sAge : " + selectedStudent.getsAge() + "\t");
		System.out.print("| sGender : " + selectedStudent.getsGender() + "\t");
		System.out.print("| sMajor : " + selectedStudent.getsMajor() + "\n");
		System.out.println("END --------------------");

		// 학생 정보 수정
		System.out.println("----------학생 정보 수정");
		StudentModifyService modifyService = ctx.getBean("studentModifyService", StudentModifyService.class);
		modifyService.modify(new Student("hbs006", "pig", "p0066", "mellisa", 27, 'W', "Computer"));

		printStudentInformationService.printStudentsInfo();

		// 학생 정보 삭제
		System.out.println("----------학생 정보 삭제");
		StudentDeleteService deleteService = ctx.getBean("studentDeleteService", StudentDeleteService.class);
		deleteService.delete("hbs005");

		printStudentInformationService.printStudentsInfo();

		// EMS 출력
		System.out.println("----------EMS 출력");
		EMSInformationService emsInformationService = ctx.getBean("EMSInformation", EMSInformationService.class);
		emsInformationService.printEMSInformation();

		ctx.close();
	}
}
