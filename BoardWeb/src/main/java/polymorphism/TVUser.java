package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

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
		
//		// 결합도 낮추는 방법2: 팩토리패턴 사용해서 (방법1은 인터페이스 사용해서ㅇㅇ)
//		BeanFactory factory = new BeanFactory();
//		Scanner sc = new Scanner(System.in);
//		System.out.println("제조사를 입력하세요");
//		TV tv = (TV) factory.getBean(sc.next());
//		// TV tv = (TV) factory.getBean(args[0]); // main함수 실행할 때, 들어오는 arguments로 넣겠다는 뜻임
//		// 패키지 오른쪽마우스 - run as - run configurations - (x)=arguments칸에 쓰면 됨
//		// samsung lg 이렇게 띄어쓰기로 주면, 첫인덱스가 samsung, 두번째 인덱스가 lg인 셈임
//		tv.powerOn();
//		tv.powerOff();
//		tv.volumeUp();
//		tv.volumeDown();
		
		/* src-main-resources-applicationContext.xml에서 bean 작성 = 스프링 설정 파일 작성
		 - -> 이제, tv객체를 테스트하는 클라이언트 만들어보기 / 컨+스페이스해서 자동완성
		 - 스프링 컨테이너 활용법
		 - 위처럼 코드 1줄 작성만해도, 이제 bean에 등록된 samsung의 생성자 함수가 바로 출력돼서, 객.체.생성.됨
		 	-> print: 삼성 TV 객체 생성 완료
		 - 
		*/
		// Step1: Spring컨.테이너를 구.동한다 - 팩토리컨테이너임 컨테이너ㅇㅇ.
			// 컨테이너안의 것들 호출은 getBean이 담당하는 거고
		AbstractApplicationContext factory = // factory가 컨테이너임ㅇㅇ 
				new GenericXmlApplicationContext("applicationContext.xml");
		// Step2: Spring컨테이너로부터 필요한 객체를 요청(Lookup)한다
		TV tv = (TV) factory.getBean("tv"); // acC.xml에서 id가 tv인것 - 아니 factory는 AAC클래스타입인데, getBean이 되네 이거 BeanFactory껀데
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// (Step5)
		// TODO: Step6 中: 단, 여기서는 sony객체 생성은 안됨. 이미 위에서 만들어졌으니까
		TV tv1 = (TV)factory.getBean("tv");
		TV tv2 = (TV)factory.getBean("tv");
		TV tv3 = (TV)factory.getBean("tv");
		System.out.println(tv1); 
		System.out.println(tv2);
		System.out.println(tv3);
		
		// Step3: Spring컨테이너를 종료한다 
		factory.close();
		
		// Step4: init,destroy메서드 추가하면 이제 순서가 어케되는가?
		/* 
		삼성 TV 객체 생성 완료 - 1
		객체 초.기화 작업 완료 - 2: 객체 생성 후에, 초기화!
		삼성티비 - 전원 켠다
		삼성티비 - 소리 올린다
		삼성티비 - 소리 내린다
		삼성티비 - 전원 끈다
		객체 삭제 전 처리할 명령을 지정하는 부분 - final
		*/
		// Step5: 이제 scope="singleton"속성도 부여해서 확인해보자
			// -> prototype도 해보자
		/*
		 * 싱글톤이면 tv1~3은 같은 참조주소고, 스코프속성이 프로토타입이면 다른 주소가 나옴
		 * 와 씨;; 쩐다.. 깊은 복사를 해주는 셈이잖아?
		 */
		

		// Step6: applicationContext.xml에 삼성bean에 소니 ref를 추가함
			// 이제 출력결과는 삼성의 생성자 함수는 삼성객체(2)가 출력되고, 볼륨업다운도 sony로 바뀐다
			// 6-2: price를 추가 -> constructor-arg ref가 아니라, value임 이번엔
				// 이거 추가하면, 이제 삼성version3가 호출된다
		
		
	}
}