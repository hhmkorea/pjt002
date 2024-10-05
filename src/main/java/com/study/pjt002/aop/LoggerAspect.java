package com.study.pjt002.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

/**
 * packageName    : com.study.pjt002.aop
 * fileName       : LoggerAspect
 * author         : dotdot
 * date           : 2024-10-05
 * description    : signature 객체 정보로 어떤 클래스에 어떤 메서드가 호출되었는지 로그로 출력
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-05        dotdot       최초 생성
 */

@Slf4j
@Aspect
@Component // 개발자가 직접 정의한 클래스롤 Bean으로 등록
public class LoggerAspect {

    @Around("execution(* com.study.pjt002.domain..*Controller.*(..)) || execution(* com.study.pjt002.domain..*Service.*(..)) || execution(* com.study.pjt002.domain..*Mapper.*(..))")
    public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable {

        String name = joinPoint.getSignature().getDeclaringTypeName(); // getSignature : 클래스와 메서드 정보 담은 객체 --- 대상 파일의 경로(패키지 + 파일명)
        String type = StringUtils.contains(name, "Controller") ? "Controller ===> "
                : StringUtils.contains(name, "Service") ? "Service ===> "
                : StringUtils.contains(name, "Mapper") ? "Mapper ===> "
                : "";

        log.debug(type + name + "." + joinPoint.getSignature().getName() + "()");
        return joinPoint.proceed();
    }
}
