package sample;
public class Multiply implements ICalculator {
	@Override
	public int doOperation(int firstNum, int secondNum) {
		return firstNum * secondNum;
	}
}