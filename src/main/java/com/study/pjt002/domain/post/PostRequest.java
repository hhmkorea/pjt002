package com.study.pjt002.domain.post;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : com.study.pjt002.domain
 * fileName       : PostRequest
 * author         : dotdot
 * date           : 2024-10-03
 * description    : 게시글 요청(등록/수정) parameter를 담은 통(class) + 파일 업로드 파라매터
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-03        dotdot       최초 생성
 */

@Getter
@Setter
public class PostRequest {

    private Long id;                                        // PK
    private String title;                                   // 제목
    private String content;                                 // 내용
    private String writer;                                  // 작성자
    private Boolean noticeYn;                               // 공지글 여부
    private List<MultipartFile> files = new ArrayList<>();  // 첨부파일 List

}
