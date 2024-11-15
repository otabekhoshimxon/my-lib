package uz.mylib;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {

    // Annotatsiyalangan metodlar uchun qo'llaniladigan @Around Advice
    @Around("@annotation(com.example.annotations.ExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        
        // Metodni bajarish
        Object result = joinPoint.proceed();
        
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        
        System.out.println(joinPoint.getSignature() + " bajarilishi " + executionTime + " ms vaqt oldi.");
        
        return result;
    }
}
