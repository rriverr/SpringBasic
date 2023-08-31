package sample;

public class CalcAssembler {
	ICalculator calculator;
	
	public static ICalculator assemble(char operator) {
		return switch (operator) {
			case '+' -> new Add();
			case '-' -> new Subtract();
			case '*' -> new Multiply();
			case '/' -> new Divide();
			case '%' -> new Modulo();
			default -> throw new IllegalArgumentException();
		};
	}
}