package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUser7 {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("appContext.xml");
		TV tv = (TV)factory.getBean("tv6");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		factory.close();
		
	}

}
