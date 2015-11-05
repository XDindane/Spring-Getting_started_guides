package spring.consuming_a_restful_ws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) //indicate that any properties not bound in this type should be ignored.
public class Value {

    private Long id;
    private String quote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String qoute) {
        this.quote = qoute;
    }

    @Override
    public String toString() {
        return "Value{"
                + "id=" + id
                + ", quote='" + quote + '\''
                + '}';
    }

}
