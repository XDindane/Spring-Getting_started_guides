package io.spring.messaging_with_redis;

import java.util.concurrent.CountDownLatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The Receiver is a simple POJO that defines a method for receiving messages.
 * As you’ll see when you register the Receiver as a message listener, you can
 * name the message-handling method whatever you want.
 */
public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
    private CountDownLatch latch;

    @Autowired
    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }

    /**
     * For demonstration purposes, it is autowired by its constructor with a
     * countdown latch. That way, it can signal when it has received a message.
     */
    public void receiveMessage(String message) {
        LOGGER.info("Received <" + message + ">");
        latch.countDown();
    }

}
