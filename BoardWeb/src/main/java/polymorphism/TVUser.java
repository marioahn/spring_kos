package polymorphism;

import java.util.Scanner;

public class TVUser {
	public static void main(String[] args) {
//		SamsungTV tv = new SamsungTV();
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
//		
//		LgTV tv2 = new LgTV();
//		tv2.powerOn();
//		tv2.volumeUp();
//		tv2.volumeDown();
//		tv2.powerOff();
		
		// 결합도 낮추는 방법2: 팩토리패턴 사용해서 (방법1은 인터페이스 사용해서ㅇㅇ)
		BeanFactory factory = new BeanFactory();
		Scanner sc = new Scanner(System.in);
		System.out.println("제조사를 입력하세요");
		TV tv = (TV) factory.getBean(sc.next());
		tv.powerOn();
		
	}
}
