package com.example.musiclist.AOP;

import com.example.musiclist.Dto.UserSignInDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class sessionAspect {
    @Pointcut("execution(public * com.example.musiclist.controller.UserController.login(..))")
    private void loginTarget() {
    }

    @Around("loginTarget() && args(request,..)")
    public Object sessioncheck(final ProceedingJoinPoint joinPoint, final HttpServletRequest request) throws Throwable {

        HttpSession session = request.getSession();
        Object login=joinPoint.proceed();
        ResponseEntity<UserSignInDto> responseEntity= null;

        if(session==null){
            return new ResponseEntity<UserSignInDto>(HttpStatus.NOT_FOUND);
        }
        else {
            log.info("request {} ",joinPoint.getSignature().toShortString());
            return login;
        }
    }
}
