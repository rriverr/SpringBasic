package sample;

public class Calc {
	ICalculator calculator;
	int num1;
	int num2;
	
	public Calc(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public int calculator(char operator) {
		this.calculator = CalcAssembler.assemble(operator);
		return calculator.doOperation(num1, num2);
	}
	
	public void showCalcResult(char operator) {
		int result = calculator(operator);
		System.out.println(result);
	}
}