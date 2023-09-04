package ch04_pjt_01.ems;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch04_pjt_01.ems.member.Student;
import ch04_pjt_01.ems.member.service.EMSInformationService;
import ch04_pjt_01.ems.member.service.PrintStudentInformationService;
import ch04_pjt_01.ems.member.service.StudentDeleteService;
import ch04_pjt_01.ems.member.service.StudentModifyService;
import ch04_pjt_01.ems.member.service.StudentRegisterService;
import ch04_pjt_01.ems.member.service.StudentSelectService;
import ch04_pjt_01.ems.utils.InitSampleData;

public class MainClass {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
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
		System.out.println("----------xml 파일에 주입한 학생 정보 register");
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
		System.out.println("| sNum : " + selectedStudent.getsNum() + "\t");
		System.out.println("| sId : " + selectedStudent.getsId() + "\t");
		System.out.println("| sPw : " + selectedStudent.getsPw() + "\t");
		System.out.println("| sName : " + selectedStudent.getsName() + "\t");
		System.out.println("| sAge : " + selectedStudent.getsAge() + "\t");
		System.out.println("| sGender : " + selectedStudent.getsGender() + "\t");
		System.out.println("| sMajor : " + selectedStudent.getsMajor() + "\t");
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

		EMSInformationService emsInformationService = ctx.getBean("EMSInformation", EMSInformationService.class);
		emsInformationService.printEMSInformation();
		
		ctx.close();
	}
}
