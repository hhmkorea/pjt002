package com.study.pjt002.config;

import com.study.pjt002.interceptor.LoggerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * packageName    : com.study.pjt002.config
 * fileName       : WebWvcConfig
 * author         : dotdot
 * date           : 2024-10-05
 * description    : Interceptor 클래스를 Bean으로 동록해줌.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-05        dotdot       최초 생성
 */

@Configuration
public class WebWvcConfig implements WebMvcConfigurer { // WebMvcConfigurer : @EnableWebMVc의 자동 설정을 베이스로 가져감.

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggerInterceptor())
                .excludePathPatterns("/css/**", "/images/**", "/js/**");
    }
}
