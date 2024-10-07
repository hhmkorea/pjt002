package com.study.pjt002.domain.comment;

import lombok.Getter;

import java.time.LocalDateTime;

/**
 * packageName    : com.study.pjt002.domain.comment
 * fileName       : CommentResponse
 * author         : dotdot
 * date           : 2024-10-07
 * description    : 댓글 응답 parameter를 담은 통(class)
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-07        dotdot       최초 생성
 */

@Getter
public class CommentResponse {

    private Long id;                    // 댓글 번호 (PK)
    private Long postId;                // 게시글 번호 (FK)
    private String content;             // 내용
    private String writer;              // 작성자
    private Boolean deleteYn;           // 삭제 여부
    private LocalDateTime createDate;   // 생성일시
    private LocalDateTime modifiedDate; // 최종 수정일시
    
}
