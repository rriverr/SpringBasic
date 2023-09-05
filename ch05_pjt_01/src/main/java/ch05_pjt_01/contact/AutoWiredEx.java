package ch05_pjt_01.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AutoWiredEx {
	@Autowired
	public AutoWiredEx(@Qualifier("usedBean") FirstBean fBean, SecondBean sBean) {
		System.out.println("fBean : "+fBean);
		System.out.println("sBean : "+sBean);
	}
	
	@Autowired
	public void autoWiredMethod(ThirdBean tBean,@Qualifier("usedBean") FourthBean fBean) {
		System.out.println("tBean : "+tBean);
		System.out.println("fBean : "+fBean);
	}
	
	// 결과 
//	fBean : ch05_pjt_01.contact.FirstBean@54422e18
//	sBean : ch05_pjt_01.contact.SecondBean@117159c0
//	tBean : ch05_pjt_01.contact.ThirdBean@1cf6d1be
//	fBean : ch05_pjt_01.contact.FourthBean@663c9e7a
	
	// autoWiredMethod는 실행 구문이 없었는데도 알아서 실행돼서 sysout까지 찍힘. 
	// => @Autowired 어노테이션이 알아서 했따. 
	// 비슷한 bean이 여러개였던 FirstBean과 FourthBean이 알아서 채워진 것도 볼 수 있다. 
	// => Qualifier!  
}
