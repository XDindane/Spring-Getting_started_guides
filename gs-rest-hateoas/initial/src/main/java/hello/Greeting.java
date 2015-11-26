package hello;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

// resourcessuppor === HATEOAS
public class Greeting extends ResourceSupport {

    private final String content;
    
    
    
    @JsonCreator // signal on how Jackson can create an instance of this POJO
    public Greeting(@JsonProperty("content") String content) { // JsonProperty clearly marks what field Jackson should put this constructor argument into
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
