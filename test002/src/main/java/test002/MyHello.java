package test002;


public class MyHello {
	public void HelloLanguage(IHello hello) {
		String value = hello.Hello();
		System.out.println(value);
	}
}