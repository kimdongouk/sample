package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUser4 {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("appContext.xml");
		TV tv1 = (TV)factory.getBean("tv");
		TV tv2 = (TV)factory.getBean("tv");
		TV tv3 = (TV)factory.getBean("tv");
		System.out.println(tv1);
		System.out.println(tv2);
		System.out.println(tv3);
//		tv.powerOn();
//		tv.volumeUp();
//		tv.powerOff();
		factory.close();
		
	}

}
