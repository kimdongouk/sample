package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUser5 {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("appContext.xml");
		TV tv = (TV)factory.getBean("tv4");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		factory.close();
		
	}

}
