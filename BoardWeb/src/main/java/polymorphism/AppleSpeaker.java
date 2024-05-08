package polymorphism;

public class AppleSpeaker implements Speaker {
	public AppleSpeaker() {
		System.out.println("===> AppleSpeaker 객체 생성");
	}
	@Override
	public void volumeUp() {
		System.out.println("Apple볼륨 업");
	}
	@Override
	public void volumeDown() {
		System.out.println("Apple볼륨 다운");
	}
}
