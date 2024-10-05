package com.study.pjt002.domain.post;

import com.study.pjt002.common.dto.SearchDto;
import com.study.pjt002.common.paging.Pagination;
import com.study.pjt002.common.paging.PagingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * packageName    : com.study.pjt002.domain.post
 * fileName       : PostService
 * author         : dotdot
 * date           : 2024-10-03
 * description    : Model, 사용자(고객)의 요구사항을 처리하는 로직을 실행하는 핵심 영역.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-03        dotdot       최초 생성
 */

@Service
@RequiredArgsConstructor // 클래스 내에 final로 선언된 모든 멤버에 대한 생성자를 만들어줌.
public class PostService {

    private final PostMapper postMapper;

    /**
     * 게시글 저장
     * @param params - 게시글 정보
     * @return Generated PK
     */
    @Transactional // 메서드 실행과 동시에 트랜잭션 시작, 정상 종료 여부에 따라 Commit or Rollback
    public Long savePost(final PostRequest params) {
        postMapper.save(params);
        return params.getId();
    }

    /**
     * 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    public PostResponse findPostById(final Long id) {
        return postMapper.findById(id);
    }

    /**
     * 게시글 수정
     * @param params - 게시글 정보
     * @return PK
     */
    @Transactional
    public Long updatePost(final PostRequest params) {
        postMapper.update(params);
        return params.getId();
    }

    /**
     * 게시글 삭제
     * @param id - PK
     * @return PK
     */
    public Long deletePost(final Long id) {
        postMapper.deleteById(id);
        return id;
    }

    /**
     * 게시글 리스트 조회
     * @param params - search conditions
     * @return list & pagination information
     */
//    public List<PostResponse> findAllPost(final SearchDto params) {
//        return postMapper.findAll(params);
//    }
    public PagingResponse<PostResponse> findAllPost(final SearchDto params) {

        // 조건에 해당하는 데이터가 없는 경우, 응답 데이터에 비어있는 리스트와 null을 담아 리턴
        int count = postMapper.count(params);
        if (count < 1) {
            return new PagingResponse<>(Collections.emptyList(), null);
        }

        // Pagination 객체를 생성해서 페이지 정보 계산 후 SearchDto 타입의 객체인 params에 계산된 페이지 정보 저장.
        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);

        // 계산된 페이지 정보의 일부(limitStart, recordSize)를 기준으로 리스트 데이터 조회 후 응답 데이터 반환.
        List<PostResponse> list = postMapper.findAll(params); // 페이징 계산된 데이터로 findAll() 수행.
        return new PagingResponse<>(list, pagination); // 페이징 객체 모두 응답
    }

}
