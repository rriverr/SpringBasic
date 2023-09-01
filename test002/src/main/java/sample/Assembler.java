package sample;

import java.util.Scanner;

public class Assembler {
	Korean kor;
	English eng;
	GreetingPrinter gp;
	
	public Assembler(Korean kor, English eng, GreetingPrinter gp) {
		this.kor = kor;
		this.eng = eng;
		this.gp = gp;
	}
	
	public void Hello() {
		// 사용자 입력
		System.out.println("Select Language ! 1. Korean, 2. English ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		switch(num) {
		case 1:
			gp.Printer(kor);
			break;
		case 2:
			gp.Printer(eng);
		break;
		}
	}
	
}
