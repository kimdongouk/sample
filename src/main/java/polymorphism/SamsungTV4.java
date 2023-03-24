package polymorphism;

public class SamsungTV4 implements TV{
	
	private SonySpeaker speaker;
	
	public SamsungTV4() {
		System.out.println("Spring SamsungTV4 객체 생성");
	}
	
	public SamsungTV4(SonySpeaker speaker) {
		System.out.println("Spring SamsungTV4 객체 생성");
		this.speaker = speaker;
	}

	public void powerOn() {
		System.out.println("SS - Power On");
	}
	public void powerOff() {
		System.out.println("SS - Power Off");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
	
}
