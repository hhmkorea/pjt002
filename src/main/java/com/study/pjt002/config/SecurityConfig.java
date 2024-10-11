package com.study.pjt002.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * packageName    : com.study.pjt002.config
 * fileName       : SecurityConfig
 * author         : dotdot
 * date           : 2024-10-09
 * description    : 스프링 Container에 Bean 등록
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-09        dotdot       최초 생성
 */

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() { // passwordEncoder() : 복호화가 불가능한 단방향 Hash 알고리즘을 제공해주는 interface
        return new BCryptPasswordEncoder();
    }

}
