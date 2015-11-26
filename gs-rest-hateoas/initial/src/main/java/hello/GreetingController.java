package hello;

import org.springframework.hateoas.core.DummyInvocationUtils;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";

    @ResponseBody
    @RequestMapping("/greeting")
    public HttpEntity<Greeting> greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {

        Greeting greeting = new Greeting(String.format(TEMPLATE, name));
        //linkTo(…) and methodOn(…) are static methods on ControllerLinkBuilder that allow you to fake a method invocation on the controller
        greeting.add(linkTo(DummyInvocationUtils.methodOn(GreetingController.class).greeting(name)).withSelfRel()); //The call to withSelfRel() creates a Link instance that you add to the Greeting representation model.

        return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);

    }

}
