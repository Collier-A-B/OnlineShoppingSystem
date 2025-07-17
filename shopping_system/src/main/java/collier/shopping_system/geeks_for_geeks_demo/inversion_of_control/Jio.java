package collier.shopping_system.geeks_for_geeks_demo.inversion_of_control;

import org.springframework.stereotype.Component;

@Component("jioBean")
public class Jio implements Sim{
    @Override
    public void calling() {
        System.out.println("Jio Calling");
    }

    @Override
    public void data() {
        System.out.println("Jio Data");
    }
}
