package com.study.pjt002.interceptor;

import com.study.pjt002.domain.member.MemberResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * packageName    : com.study.pjt002.interceptor
 * fileName       : LoginCheckInterceptor
 * author         : dotdot
 * date           : 2024-10-18
 * description    : 로그인 상태를 체크
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-18        dotdot       최초 생성
 */
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 1. 세션에서 회원 정보 조회
        HttpSession session = request.getSession();
        MemberResponse member = (MemberResponse) session.getAttribute("loginMember");

        // 2. 회원 정보 체크
        if ( member == null || member.getDeleteYn() == true ) {
            response.sendRedirect("/login.do");
            return false;
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
