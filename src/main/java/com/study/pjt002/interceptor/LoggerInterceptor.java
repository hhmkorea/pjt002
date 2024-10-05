package com.study.pjt002.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * packageName    : com.study.pjt002.interceptor
 * fileName       : LoggerInterceptor
 * author         : dotdot
 * date           : 2024-10-05
 * description    : Controller의 URI 접근하는 과정 중 제어하는 기능
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-05        dotdot       최초 생성
 */

@Slf4j // 로깅 추상화 라이브러리.
public class LoggerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("===============================================");
        log.debug("==================== BEGIN ====================");
        log.debug("Request URI ===> " + request.getRequestURI());
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.debug("==================== END ======================");
        log.debug("===============================================");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
