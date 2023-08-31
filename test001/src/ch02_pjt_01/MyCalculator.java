package ch02_pjt_01;

public class MyCalculator {
	ICalculator ic;

	public void calculate(int fNum, int sNum, char Operator) {
		switch (Operator) {
		case '+':
			ic = new CalAdd();
			break;
		case '-':
			ic = new CalSub();
			break;
		case '*':
			ic = new CalMul();
			break;
		case '/':
			ic = new CalDiv();
			break;
		case '%':
			ic = new CalRem();
			break;
		}
		int value = ic.doOperation(fNum, sNum);
		System.out.println("RESULT : " + value);
	}
}
