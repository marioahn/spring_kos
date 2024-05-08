package polymorphism;

public class SamsungTV implements TV {
	private Speaker speaker;// private타입! - DI하려고 가져옴
	private int price;
	
	public SamsungTV() {
		System.out.println("삼성 TV 객체(1) 생성 완료");
	}
	// DI를 사용한 생성자함수 - configurations에서 bean사이에 ref있으면 이 내용 있어야 에러 안남 
	public SamsungTV(Speaker speaker) {
		System.out.println("삼성 TV 객체(2) 생성 완료");
		this.speaker = speaker;
	}
	// 인자 또 하나 추가 -> configurations에서 constructor-args추가해야지 
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("삼성 TV 객체(3) 생성 완료");
		this.speaker = speaker;
		this.price = price;
	}
	
	// bean-confirgurations파일에 samsungTV bean에 init,destroyMethod넣어주려면 여기서 만들어야겠지ㅇㅇ
	public void initMethod() {
		System.out.println("initMethod: 객체 초.기화 작업 완료");
	}
	public void destroyMethod() {
		System.out.println("destroyMethod: 객체 삭제 전 처리할 명령을 지정하는 부분");
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
		// System.out.println("삼성티비 - 소리 올린다");
		// speaker = new SonySpeaker(); // 위에서 DI생성자함수가 있으니 이제 할당ㄴㄴ. this.speaker=speaker
		speaker.volumeUp(); // 삼성의 볼륨업은 이제 소니스피커의 볼륨업이 됨 - DIㅇㅇ
	}
	@Override
	public void volumeDown() {
		// System.out.println("삼성티비 - 소리 내린다");
		speaker.volumeDown();
	}	
}
