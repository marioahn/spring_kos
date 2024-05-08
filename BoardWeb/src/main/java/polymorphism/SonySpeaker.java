package polymorphism;

public class SonySpeaker implements Speaker {
	public SonySpeaker() {
		System.out.println("===> SonySpeaker 객체 생성");
	}
	@Override
	public void volumeUp() {
		System.out.println("Sony볼륨 업");
	}
	@Override
	public void volumeDown() {
		System.out.println("Sony볼륨 다운");
	}
}
