
package io.spring.messaging_with_rabbitmq;

import java.util.concurrent.CountDownLatch;


/**
 * The Receiver is a simple POJO that defines a method for receiving messages.
 */
public class Receiver {
    
    private CountDownLatch latch = new CountDownLatch(1);

    
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }    
    
}
