package com.study.pjt002;

import com.study.pjt002.common.dto.SearchDto;
import com.study.pjt002.common.paging.PagingResponse;
import com.study.pjt002.domain.post.PostResponse;
import com.study.pjt002.domain.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName    : com.study.pjt002
 * fileName       : RestApiTestController
 * author         : dotdot
 * date           : 2024-10-06
 * description    : REST(Representational State Transfer) 테스트용 Controller
 *                  화면(HTML)이 아닌 데이터 자체를 리턴한다.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-06        dotdot       최초 생성
 */
// @RestController : 클래스 레벨에서 선언, 자동으로 @ResponseBody가 적용됨.
@RestController
@RequiredArgsConstructor
public class RestApiTestController {

    private final PostService postService;

    @GetMapping("/posts") // http://localhost:8080/posts
    public PagingResponse<PostResponse> findAllPost() {
        return postService.findAllPost(new SearchDto());
    }
}


// @ResponseBody : HTML이 아닌 리턴 타입에 해당하는 데이터 자체 리턴
/*@Controller
public class RestApiTestController {

    @GetMapping("/members") // http://localhost:8080/members
    @ResponseBody // public @ResponseBody List<Map<String, Object>> findAllMember()와 같이 리턴 타입 앞에도 선언 가능
    public List<Map<String, Object>> findAllMember() {

        List<Map<String, Object>> members = new ArrayList<>();

            for (int i = 1; i <= 20; i++) {
                Map<String, Object> member = new HashMap<>();
                member.put("id", 1);
                member.put("name", i + "번 개발자");
                member.put("age", 10 + i);
                members.add(member);
            }

            return members;
    }
}*/
