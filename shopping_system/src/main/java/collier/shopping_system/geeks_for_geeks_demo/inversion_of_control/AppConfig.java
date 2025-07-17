package collier.shopping_system.geeks_for_geeks_demo.inversion_of_control;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "collier.shopping_system.geeks_for_geeks_demo.inversion_of_control")
public class AppConfig {
    @Bean
    public Sim sim() {
        return new Jio(); // Change to new Airtel() to switch implementations
    }
}
