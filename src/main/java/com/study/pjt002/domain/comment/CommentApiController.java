package com.study.pjt002.domain.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * packageName    : com.study.pjt002.domain.comment
 * fileName       : CommentApiController
 * author         : dotdot
 * date           : 2024-10-07
 * description    : 서비스 호출하고 그에 대한 실행 결과 전달
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-07        dotdot       최초 생성
 */

@RestController // REST API, 비동기방식, 모든 메서드 @ResponseBody 적용, 리턴타입은 html(x), 데이터(o)
@RequiredArgsConstructor
public class CommentApiController {

    private final CommentService commentService;

    // 신규 댓글 생성
    @PostMapping("/posts/{postId}/comments")
    public CommentResponse saveComment(@PathVariable final Long postId, @RequestBody final CommentRequest params) {
        Long id = commentService.saveComment(params);
        return commentService.findCommentById(id);
    }

    // 댓글 리스트 조회
    @GetMapping("/posts/{postId}/comments")
    public List<CommentResponse> findAllComment(@PathVariable final Long postId) {
        return commentService.findAllComment(postId);
    }

    // 댓글 상세정보 조회
}
