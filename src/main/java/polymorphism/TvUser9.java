package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUser9 {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("appContextAnno.xml");
		TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		factory.close();
	}
}
