package sample;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		// Spring Context 객체화 => 클래스에 객체 정보 전달
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		Assembler as = ctx.getBean("as", Assembler.class);
		
		as.Hello();
		ctx.close();
	}
}

// 1. 클래스 정보를 xml파일에 bean으로 등록
// 2. context를 통해 객체를 생성하고, 클래스에 객체의 정보를 집어넣어줌 
//    => Line 8. 'greeting' Bean의 정보를 Greeting 클래스에 넣어줌

