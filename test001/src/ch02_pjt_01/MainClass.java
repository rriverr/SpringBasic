package ch02_pjt_01;

public class MainClass {

	public static void main(String[] args) {
//		new CalAssembler(); // 객체를 생성 = 생성자 호출 = 실행
		MyCalculator calc = new MyCalculator();
		calc.calculate(10, 5, '+');
		calc.calculate(10, 5, '-');
		calc.calculate(10, 5, '*');
		calc.calculate(10, 5, '/');
		calc.calculate(10, 5, '%');
	}
}
