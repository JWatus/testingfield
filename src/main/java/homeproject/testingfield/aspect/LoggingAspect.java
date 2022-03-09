package homeproject.testingfield.aspect;

import homeproject.testingfield.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LogManager.getLogger(UserService.class);

    @Around("execution(* homeproject.testingfield.service.UserService.findUserById(..))")
    public Object logEvent(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("Get user by ID started");
        Object proceed = joinPoint.proceed();
        LOGGER.info("Get user by ID ended");
        return proceed;
    }
}