package test003.hanb;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.context.support.GenericXmlApplicationContext;

import test003.hanb.member.Member;
import test003.hanb.member.service.MemberDeleteService;
import test003.hanb.member.service.MemberModifyService;
import test003.hanb.member.service.MemberRegisterService;
import test003.hanb.member.service.MemberSelectService;
import test003.hanb.member.service.PrintMemberInformationService;
import test003.hanb.utils.InitSampleData;

public class MainClass {
	public static void main(String[] args) {
		String[] appCtx = { "classpath:appCtx1.xml", "classpath:appCtx2.xml", "classpath:appCtx3.xml" };
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(appCtx);

		InitSampleData initSampleData = ctx.getBean("initSampleData", InitSampleData.class);
		String[] mIds = initSampleData.getmIds();
		String[] mPws = initSampleData.getmPws();
		String[] mPhones = initSampleData.getmPhones();
		String[] mMails = initSampleData.getmMails();
		String[] mRegDays = initSampleData.getmRegDays();
		String[] mModDays = initSampleData.getmModDays();

		System.out.println("-----기본 회원 입력-----");
		MemberRegisterService registerService = ctx.getBean("memberRegisterService", MemberRegisterService.class);
		for (int i = 0; i < mIds.length; i++) {
			registerService.register(new Member(mIds[i], mPws[i], mPhones[i], mMails[i], mRegDays[i], mModDays[i]));
		}

		PrintMemberInformationService printMemberInformationService = ctx.getBean("printMemberInformationService",
				PrintMemberInformationService.class);
		printMemberInformationService.printMembersInfo();

		System.out.println("-----특정 멤버 조회-----");
		MemberSelectService selectService = ctx.getBean("memberSelectService", MemberSelectService.class);
		Member selectedMember = selectService.select("m002");
		System.out.println("----------MEMBER LIST START----------");
		System.out.print("mId : " + selectedMember.getmId()+"\t");
		System.out.print("| mPw : " + selectedMember.getmPw()+"\t");
		System.out.print("| mPhone : " + selectedMember.getmPhone()+"\t");
		System.out.print("| mMail : " + selectedMember.getmMail()+"\t");
		System.out.print("| mRegDay : " + selectedMember.getmRegDay()+"\t");
		System.out.print("| mModDay : " + selectedMember.getmModDay()+"\n");
		System.out.println("-----------MEMBER LIST END-----------");
		
		System.out.println("-----멤버 정보 수정-----");
		MemberModifyService modifyService = ctx.getBean("memberModifyService", MemberModifyService.class);
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		modifyService.modify(new Member("m003", "pw333", "333-3333-3333", "cc@ccc.com", "2023-09-03", date.format(formatter)));
		printMemberInformationService.printMembersInfo();
		
		System.out.println("-----멤버 정보 삭제-----");
		MemberDeleteService deleteService = ctx.getBean("memberDeleteService", MemberDeleteService.class);
		deleteService.delete("m002");
		printMemberInformationService.printMembersInfo();
		
		ctx.close();
	}
}
