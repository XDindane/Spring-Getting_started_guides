
package io.spring.messaging_with_rabbitmq;

import java.util.concurrent.TimeUnit;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application implements CommandLineRunner{

    final static String queueName = "spring-boot";
    
    @Autowired
    AnnotationConfigApplicationContext context;
    
    @Autowired
    RabbitTemplate rabbitTemplate;
    
    /**
     * The queue() method creates an AMQP queue.
     * @return Queue
     */
    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    /**
     * The exchange() method creates a topic exchange.
     * @return 
     */
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("spring-boot-exchange");
    }
    
    /**
     * The binding() method binds these two together, defining the behavior that occurs when RabbitTemplate publishes to an exchange.
     * 
     * Note:  Spring AMQP requires that the Queue, the TopicExchange, and the Binding be declared as top level Spring beans in order to be set up properly.
     * @param Queue queue
     * @param TopicExchange exchange
     * @return 
     */
    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(queueName);
    }
    
    
    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        
        return container;
    }
    
    
    @Bean
    Receiver receiver() {
        return new Receiver();
    }
    
    /**
     * The bean defined in the listenerAdapter() method is registered as a message listener in the container defined in container()
     * @param receiver
     * @return 
     */
    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }
    
    /**
     *  retrieves the RabbitTemplate from the application context, waits five seconds, and sends a "Hello from RabbitMQ!" message
     * @param strings
     * @throws Exception 
     */
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Waiting five seconds...");
        Thread.sleep(5000);
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(queueName, "Hello from RabbitMQ!");
        receiver().getLatch().await(10000, TimeUnit.MILLISECONDS);
        context.close();
    }
    
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    
    
}
