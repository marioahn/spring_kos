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
//		TV tv = (TV) factory.getBean(args[0]); // main함수 실행할 때, 들어오는 arguments로 넣겠다는 뜻임
		// 패키지 오른쪽마우스 - run as - run configurations - (x)=arguments칸에 쓰면 됨
		// samsung lg 이렇게 띄어쓰기로 주면, 첫인덱스가 samsung, 두번째 인덱스가 lg인 셈임
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
	}
}