package ejemplo05beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LanzadorSpring {

	public static void main(String[] args) {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans1.xml");	
	MorcillaDeLeon morcilla = (MorcillaDeLeon)applicationContext.getBean("morcillaDeLeon");
	System.out.println(morcilla);
	morcilla.setColor("está que te mueres!!");
	morcilla.setSabor("esta es de Villada!");
	MorcillaDeLeon otraMorcilla = (MorcillaDeLeon)applicationContext.getBean("morcillaDeLeon");
	System.out.println(morcilla);
	System.out.println(otraMorcilla);
	}
	
}
