package collier.shopping_system.geeks_for_geeks_demo.inversion_of_control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Mobile {

    @Autowired
    @Qualifier("jioBean")   // specify bean name
    private Sim sim;

    public void useSim() {
        sim.calling();
        sim.data();
    }

    public static void main(String[] args) {
        // Manually creating instance of Jio
        Sim sim0 = new Jio();

        // Calling methods
        sim0.calling();
        sim0.data();

        // Using ApplicationContext tom implement Spring IoC
        ApplicationContext applicationContext1 
        = new ClassPathXmlApplicationContext("beans.xml");
        
        // Get the bean
        Sim sim1 = applicationContext1.getBean("sim", Sim.class);
        
        // Calling the methods
        sim1.calling();
        sim1.data();

        // Load the Spring IoC container 
        // using Java-based configuration
        ApplicationContext context 
        = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the bean
        Sim sim2 = context.getBean("sim", Sim.class);

        // Call methods
        sim2.calling();
        sim2.data();

        // Using dependency injection with @Autowired
        ApplicationContext context1 = new AnnotationConfigApplicationContext(AppConfig.class);
        Mobile mobile = context.getBean(Mobile.class);
        mobile.useSim();
        
    }
}
