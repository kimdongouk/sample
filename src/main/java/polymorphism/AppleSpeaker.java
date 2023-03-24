package polymorphism;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker{
	public AppleSpeaker() {
		System.out.println("Apple Speaker 생성");
	}
	
	public void volumeUp() {
		System.out.println("Sony - Volume Up");
	}
	public void volumeDown() {
		System.out.println("Sony - Volume Down");
	}
}
