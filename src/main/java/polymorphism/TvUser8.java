package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUser8 {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("appContext.xml");
		TV tv = (TV)factory.getBean("tv7");
		TV tv71 = (TV)factory.getBean("tv71");
		
		factory.close();
		
	}

}
