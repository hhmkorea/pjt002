package com.study.pjt002.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.study.pjt002.domain.member
 * fileName       : MemberService
 * author         : dotdot
 * date           : 2024-10-09
 * description    : 비즈니스 로직 담당하는 서비스 클래스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-09        dotdot       최초 생성
 */

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;

    // 회원정보 저장(회원가입)

    // 회원 상세정보 조회

    // 회원 정보 수정

    // 회원 정보 삭제

    // 회원 수 카운팅
}
