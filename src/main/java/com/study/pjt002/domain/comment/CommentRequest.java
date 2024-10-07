package com.study.pjt002.domain.comment;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.study.pjt002.domain.comment
 * fileName       : CommentRequest
 * author         : dotdot
 * date           : 2024-10-07
 * description    : 댓글 요청 parameter를 담은 통(class)
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-07        dotdot       최초 생성
 */

@Getter // Lombok이 제공해주는 기능, 클래스의 모든 멤버 변수에 대한 get() 메서드를 만들어줌.
//@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 클래스의 기본 생성자를 만들어줌.
public class CommentRequest {

    private Long id;            // 댓글 번호 (PK)
    private Long postId;        // 게시글 번호 (FK)
    private String content;     // 내용
    private String writer;      // 작성자
}
