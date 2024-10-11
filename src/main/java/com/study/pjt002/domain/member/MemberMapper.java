package com.study.pjt002.domain.member;

import org.apache.ibatis.annotations.Mapper;

/**
 * packageName    : com.study.pjt002.domain.member
 * fileName       : MemberMapper
 * author         : dotdot
 * date           : 2024-10-09
 * description    : DB와 통신할 MyBatis의 Mapper 인터페이스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-09        dotdot       최초 생성
 */
@Mapper
public interface MemberMapper {

    /**
     * 회원 정보 저장 (회원가입)
     * @param params - 회원 정보
     */
    void save(MemberRequest params);

    /**
     * 회원 상세정보 조회
     * @param loginId - UK
     * @return 회원 상세정보
     */
    MemberResponse findByLoginId(String loginId);

    /**
     * 회원 정보 수정
     * @param params - 회원 정보
     */
    void update(MemberRequest params);

    /**
     * 회원 정보 삭제 (회원 탈퇴)
     * @param id - PK
     */
    void deleteById(Long id);

    /**
     * 회원 수 카운팅 (ID 중복 체크)
     * @param loginId - UK
     * @return 회원 수
     */
    int countByLoginId(String loginId);

}
