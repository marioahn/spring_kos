package polymorphism;

public class SamsungTV implements TV {
	
	public SamsungTV() {
		System.out.println("삼성 TV 객체 생성 완료");
	}
	// bean-confirgurations파일에 samsungTV bean에 init,destroyMethod넣어주려면 여기서 만들어야겠지ㅇㅇ
	public void initMethod() {
		System.out.println("객체 초.기화 작업 완료");
	}
	public void destroyMethod() {
		System.out.println("객체 삭제 전 처리할 명령을 지정하는 부분");
	}
	
	
	@Override
	public void powerOn() {
		System.out.println("삼성티비 - 전원 켠다");
	}
	@Override
	public void powerOff() {
		System.out.println("삼성티비 - 전원 끈다");
	}
	@Override
	public void volumeUp() {
		System.out.println("삼성티비 - 소리 올린다");
	}
	@Override
	public void volumeDown() {
		System.out.println("삼성티비 - 소리 내린다");
	}	
}
