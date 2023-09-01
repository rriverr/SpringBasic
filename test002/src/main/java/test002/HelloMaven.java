package test002;

import java.util.Scanner;

public class HelloMaven {
	int num;
	MyHello h;
	Korean kr;
	English en;

	public HelloMaven(Korean kr, English en, MyHello h) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Select Language !! 1. Korean, 2. English");
		int num = sc.nextInt();
		this.num = num;
		this.kr = kr;
		this.en = en;
		this.h = h;
	}

	public void hello() {
		switch(num) {
		case 1:
			h.HelloLanguage(kr);
			break;
		case 2:
			h.HelloLanguage(en);
			break;
		}
	}
}
