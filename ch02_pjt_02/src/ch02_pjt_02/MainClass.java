package ch02_pjt_02;

public class MainClass {

	public static void main(String[] args) {
		MyCalculator calculator = new MyCalculator();
		calculator.calculate(10, 5, new CalAdd());
		// 여기서 아예 새로 생성해서 집어넣은 걸 받아다 쓰는 것 = 의존성 주입
		calculator.calculate(10, 5, new CalSub());
		calculator.calculate(10, 5, new CalMul());
		calculator.calculate(10, 5, new CalDiv());
	}
}
