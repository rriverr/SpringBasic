package sample;

public class Subtract implements ICalculator {
	@Override
	public int doOperation(int firstNum, int secondNum) {
		return firstNum - secondNum;
	}
}