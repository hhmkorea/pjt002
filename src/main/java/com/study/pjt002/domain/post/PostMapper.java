package com.study.pjt002.domain.post;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * packageName    : com.study.pjt002.domain.post
 * fileName       : PostMapper
 * author         : dotdot
 * date           : 2024-10-03
 * description    : DB와의 통신(CRUD) 역할을 하는 Mapper 인터페이스.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-03        dotdot       최초 생성
 */

@Mapper
public interface PostMapper {

    /**
     * 게시글 저장
     * @param params - 게시글 정보
     */
    void save(PostRequest params);

    /**
     * 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    PostResponse findById(Long id);

    /**
     * 게시글 수정
     * @param params - 게시글 정보
     */
    void update(PostRequest params);

    /**
     * 게시글 삭제
     * @param id - PK
     */
    void deleteById(Long id);

    /**
     * 게시글 리스트 조회
     * @return 게시글 리스트
     */
    List<PostResponse> findAll();

    /**
     * 게시글 수 카운팅
     *
     * @return 게시글 수
     */
    default int count() {
        return 0;
    }

}
