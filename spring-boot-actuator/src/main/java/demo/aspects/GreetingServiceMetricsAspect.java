package demo.aspects;

import java.util.NoSuchElementException;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Component;

@Aspect
@Component
class GreetingServiceMetricsAspect {

    @Autowired
    private CounterService counterService;

    @AfterReturning(pointcut = "execution(* demo.service.greeting.GreetingService.getGreeting(int)) && args(number)", argNames = "number")
    public void afterCallingGetGreeting(int number) {
        counterService.increment("counter.calls.get_greeting_aspect");
        counterService.increment("counter.calls.get_greeting_aspect." + number);
    }

    @AfterThrowing(pointcut = "execution(* demo.service.greeting.GreetingService.getGreeting(int))", throwing = "e")
    public void afterGetGreetingThrowsException(NoSuchElementException e) {
        counterService.increment("counter.errors.get_greeting_aspect");
    }

}
