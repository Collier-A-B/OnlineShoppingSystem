package collier.shopping_system.geeks_for_geeks_demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// https://www.geeksforgeeks.org/advance-java/spring-boot/
// under "How to Run Spring Boot Application?"
//
// part of geeks for geeks tutorial on springboot
// not part of actual application, just here for reference/learning
//
// for testing, run the project from the app file and append "/hello" to the url

@Controller
public class DemoController {
    @RequestMapping("/hello")
    @ResponseBody
    public String helloWorld()
    {
        return "Hello World!";
    }
}
