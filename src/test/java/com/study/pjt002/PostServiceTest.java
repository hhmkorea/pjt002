package com.study.pjt002;

import com.study.pjt002.domain.post.PostRequest;
import com.study.pjt002.domain.post.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * packageName    : com.study.pjt002
 * fileName       : PostServiceTest
 * author         : dotdot
 * date           : 2024-10-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-03        dotdot       최초 생성
 */
@SuppressWarnings("ALL")
public class PostServiceTest {

    @Autowired
    PostService postService; // PostService Bean을 클랙스에 주입.

    @Test
    void save() {
        PostRequest params = new PostRequest();
        params.setTitle("1번 게시글 제목");
        params.setContent("1번 게시글 내용");
        params.setWriter("테스터");
        params.setNoticeYn(false);
        Long id = postService.savePost(params);
        System.out.println("생성된 게시글 ID : " + id);
    }

}
