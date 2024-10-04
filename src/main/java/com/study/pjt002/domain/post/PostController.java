package com.study.pjt002.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * packageName    : com.study.pjt002.domain.post
 * fileName       : PostController
 * author         : dotdot
 * date           : 2024-10-04
 * description    : 서비스 호출하고 그에 대한 실행 결과 전달
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
    public String openPostWrite(@RequestParam(value = "id", required = false) final Long id, Model model) { // @RequestParam : HTML에서 보낸 파라매터 전달 받는데 사용

        if (id != null) {
            PostResponse post = postService.findPostById(id);
            model.addAttribute("post", post);
        }
        return "post/write"; // src/main/resources/templates/post/write.html
    }

    // 신규 게시글 생성
    @PostMapping("/post/save.do")
    public String savePost(final PostRequest params) { // PostRequest : 등록 요청 데이터를 담은 통(class).
        postService.savePost(params);
        return "redirect:/post/list.do"; // list.do 호출
    }

    // 게시글 리스트 페이지
    @GetMapping("/post/list.do")
    public String openPostList(Model model) {
        List<PostResponse> posts = postService.findAllPost();
        model.addAttribute("posts", posts);
        return "post/list"; // src/main/resources/templates/post/list.html
    }

    // 게시글 상세 페이지
    @GetMapping("/post/view.do")
    public String openPostView(@RequestParam final Long id, Model model) {
        PostResponse post = postService.findPostById(id);
        model.addAttribute("post", post);
        return "post/view"; // src/main/resources/templates/post/view.html
    }

    // 기존 게시글 수정
    @PostMapping("/post/update.do")
    public String updatePost(final PostRequest params) {
        postService.updatePost(params);
        return "redirect:/post/list.do";
    }
}
