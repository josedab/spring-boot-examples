package demo.health;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealth implements HealthIndicator {

    private AtomicInteger errorCode = new AtomicInteger(0);

    @Override
    public Health health() {
        int errorCode = checkForError();
        if (errorCode % 2 == 0) {
            return Health.down().withDetail("Error Code Custom", errorCode)
                                .withDetail("Another custom errir", errorCode).build();
        }
        return Health.up().build();
    }

    private int checkForError() {
        return errorCode.addAndGet(1);
    }

}
