
package io.spring.authenticating_a_user_with_ldap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController // Spring MVC can autodetect the controller using it’s built-in scanning features and automatically configure web routes.
public class HomeController {
    
    @RequestMapping("/")
    public String index() {
        return "Welcome to the home page!";
    }
    
}
