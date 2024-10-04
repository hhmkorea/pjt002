package com.study.pjt002.domain.post;

import lombok.Getter;

import java.time.LocalDateTime;

/**
 * packageName    : com.study.pjt002.domain
 * fileName       : PostResponse
 * author         : dotdot
 * date           : 2024-10-03
 * description    : 게시글 응답(조회) 클래스, 사용자에게 보여줄 parameter를 담은 통(class)
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-03        dotdot       최초 생성
 */

@Getter
public class PostResponse {

    private Long id;                       // PK
    private String title;                  // 제목
    private String content;                // 내용
    private String writer;                 // 작성자
    private int viewCnt;                   // 조회 수
    private Boolean noticeYn;              // 공지글 여부
    private Boolean deleteYn;              // 삭제 여부
    private LocalDateTime createdDate;     // 생성일시
    private LocalDateTime modifiedDate;    // 최종 수정일시

}
