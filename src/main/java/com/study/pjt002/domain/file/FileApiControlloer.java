package com.study.pjt002.domain.file;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * packageName    : com.study.pjt002.domain.file
 * fileName       : FileApiControlloer
 * author         : dotdot
 * date           : 2024-10-20
 * description    : REST API 방식으로 데이터만 주고 받음.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-20        dotdot       최초 생성
 */

@RestController
@RequiredArgsConstructor
public class FileApiControlloer {

    private final FileService fileService;

    // 파일 리스트 조회
    @GetMapping("/posts/{postId}/files")
    public List<FileResponse> findAllFileByPOstId(@PathVariable final Long postId) {
        return fileService.findAllFileByPostId(postId);
    }
}
