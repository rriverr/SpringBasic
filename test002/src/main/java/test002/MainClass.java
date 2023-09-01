package test002;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		HelloMaven hm = ctx.getBean("helloMaven", HelloMaven.class);
		
		hm.hello();
		ctx.close();
	}
}
