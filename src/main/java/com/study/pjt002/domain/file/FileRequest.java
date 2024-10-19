package com.study.pjt002.domain.file;

import lombok.Builder;
import lombok.Getter;

/**
 * packageName    : com.study.pjt002.domain.file
 * fileName       : FileRequest
 * author         : dotdot
 * date           : 2024-10-19
 * description    : 파일 정보 저장하는 용도로 사용할 파일 요청 클래스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-19        dotdot       최초 생성
 */

@Getter
public class FileRequest {

    private Long id;                // 파일 번호 (PK)
    private Long postId;            // 게시글 번호 (FK)
    private String originalName;    // 원본 파일명
    private String saveName;        // 저장 파일명
    private long size;              // 파일 크기

    @Builder // Lombok에서 제공해주는 기능, Builder pattern으로 객체 생성, 생성자 파라미터가 많을 경우 가독성 좋음.
    public FileRequest(String originalName, String saveName, long size) {
        this.originalName = originalName;
        this.saveName = saveName;
        this.size = size;
    }

    public void setPostId(Long postId) { // 생성된 게시글 ID 저장. 파일은 게시글이 생성된 후에 처리되어야 함.
        this.postId = postId;
    }

/* 파일 객체 생성 예

    // 일반적인 생성자를 통한 객체 생성
    FileRequest fileRequest = new FileRequest("테스트.txt", "abcdeabcde.txt", 10768);

    // 빌더 패턴을 통한 객체 생성 1
    FileRequest fileRequest = FileRequest.builder()
            .originalName("테스트.txt")
            .saveName("abcdeabcde.txt")
            .size(10768)
            .build();

    // 빌더 패턴을 통한 객체 생성 2
    FileRequest fileRequest = FileRequest.builder()
            .size(10768)
            .saveName("abcdeabcde.txt")
            .originalName("테스트.txt")
            .build();

    // 빌더 패턴을 통한 객체 생성 3
    FileRequest fileRequest = FileRequest.builder()
            .saveName("abcdeabcde.txt")
            .build();
*/

}
