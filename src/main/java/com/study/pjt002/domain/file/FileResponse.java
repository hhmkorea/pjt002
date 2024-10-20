package com.study.pjt002.domain.file;

import lombok.Getter;

import java.time.LocalDateTime;

/**
 * packageName    : com.study.pjt002.domain.file
 * fileName       : FileResponse
 * author         : dotdot
 * date           : 2024-10-20
 * description    : DB에 저장된 파일 정보를 조회하는 용도의 응답 클래스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-20        dotdot       최초 생성
 */

@Getter
public class FileResponse {

    private Long id;                      // 파일 번호 (PK)
    private Long postId;                  // 게시글 번호 (FK)
    private String originalName;          // 원본 파일명
    private String saveName;              // 저장 파일명
    private long size;                    // 파일 크기
    private Boolean deleteYn;             // 삭제 여부
    private LocalDateTime createdDate;    // 생성일시
    private LocalDateTime deletedDate;    // 삭제일시

}
