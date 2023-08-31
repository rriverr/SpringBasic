package ch02_pjt_01;

public class CalRem implements ICalculator {
	@Override
	public int doOperation(int firstNum, int secondNum) {
		return firstNum % secondNum;
	}
}
