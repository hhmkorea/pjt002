package com.study.pjt002.domain.comment;

import com.study.pjt002.common.paging.Pagination;
import com.study.pjt002.common.paging.PagingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * packageName    : com.study.pjt002.domain.comment
 * fileName       : CommentService
 * author         : dotdot
 * date           : 2024-10-07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-07        dotdot       최초 생성
 */

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper commentMapper;  // Mapper

    /**
     * 댓글 저장
     * @param params - 댓글 정보
     * @return Generated PK
     */
    @Transactional
    public Long saveComment(final CommentRequest params) {
        commentMapper.save(params);
        return params.getId();
    }

    /**
     * 댓글 상세정보 조회
     * @param id - PK
     * @return 댓글 상세정보
     */
    public CommentResponse findCommentById(final Long id) {
        return commentMapper.findById(id);
    }

    /**
     * 댓글 수정
     * @param params - 댓글 정보
     * @return PK
     */
    @Transactional
    public Long updateComment(final CommentRequest params) {
        commentMapper.update(params);
        return params.getId();
    }

    /**
     * 댓글 삭제
     * @param id - PK
     * @return PK
     */
    @Transactional
    public Long deleteComment(final Long id) {
        commentMapper.deleteById(id);
        return id;
    }

    /**
     * 댓글 리스트 조회
     * @param params - 게시글 번호 (FK)
     * @return 특정 게시글에 등록된 댓글 리스트
     */
    public PagingResponse<CommentResponse> findAllComment(final CommentSearchDto params) {

        int count = commentMapper.count(params);
        if ( count < 1 ) {
            return new PagingResponse<>(Collections.emptyList(),null);
        }

        Pagination pagination = new Pagination(count, params);
        List<CommentResponse> list = commentMapper.findAll(params);
        return new PagingResponse<>(list, pagination);
    }

}
