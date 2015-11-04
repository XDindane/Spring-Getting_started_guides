package maven.spring.scheduling_tasks;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component // annotation marks a java class as a bean so the component-scanning mechanism of spring can pick it up and pull it into the application context.
public class ScheduledTasks {
    
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
    @Scheduled(fixedRate = 5000) // defines when a particular method runs. specifies the interval between method invocations measured from the start time of each invocation. 
    public void reportCurrentTime() {
        System.out.println("The time is now " + dateFormat.format(new Date()));
    }
}
