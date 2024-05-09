package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv") 
/* - component 어노테이션을 써주면, 이 클래스는 객체가 바로 생성되어야 하므로 생성자 함수가 필수다!!!!
   - 또한, ("tv")는 bean의 'id'인 셈이다 */
public class LgTV implements TV {	
	@Autowired // 뜻: private  peaker speaker = new SonsySpeaker()와 같음. 즉 자동으로 연결 = 객체 생성
	// @Qualifier("apple")
		// (1)speaker가 2개인데, 이거 안 써주면 어떤 스피커 가려야할지 모르니까 에러남.
		// (2)혹은, configuration에서 apple이나 sony중 1개 객체 생성해주면 됨ㅇㅇ!!
		// 어찌되었든, annotation도 객.체를 생.성시킨다는 것 잊지마라 -> annotation or bean등록 2가지 방법이 있다는 겄! 
	// @Resource(name="apple")
	private Speaker speaker; // 멤버 변수
	
	public LgTV() {
		System.out.println("===> LgTV객체 생성");
	}
	
	@Override
	public void powerOn() {
		System.out.println("엘지티비 - 전원 켠다");
	}
	@Override
	public void powerOff() {
		System.out.println("엘지티비 - 전원 끈다");
	}
	@Override
	public void volumeUp() {
		// System.out.println("엘지티비 - 소리 올린다");
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		// System.out.println("엘지티비 - 소리 내린다");
		speaker.volumeDown();
	}	
}
