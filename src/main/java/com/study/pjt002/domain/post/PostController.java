package com.study.pjt002.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * packageName    : com.study.pjt002.domain.post
 * fileName       : PostController
 * author         : dotdot
 * date           : 2024-10-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-04        dotdot       최초 생성
 */
@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 게시글 작성 페이지
    @GetMapping("/post/write.do")
    // 과거 : @RequestMapping(value = "...", method = RequestMethod.XXX)
    // 현재 : @xxxMapping("...")
    public String openPostWrite(Model model) {
        String title = "제목",
                content = "내용",
                writer = "홍길동";

        model.addAttribute("t", title);
        model.addAttribute("e", content);
        model.addAttribute("w", writer);
        return "post/write"; // HTML 파일 경로 선언, http://localhost:8080/post/write.do
    }
}
