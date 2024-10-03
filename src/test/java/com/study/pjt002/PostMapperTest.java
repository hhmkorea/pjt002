package com.study.pjt002;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.study.pjt002.domain.post.PostMapper;
import com.study.pjt002.domain.post.PostRequest;
import com.study.pjt002.domain.post.PostResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

/**
 * packageName    : com.study.pjt002
 * fileName       : PostMapperTest
 * author         : dotdot
 * date           : 2024-10-03
 * description    : CRUD 테스트
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-03        dotdot       최초 생성
 */

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringBootTest
public class PostMapperTest {

    @Autowired
    PostMapper postMapper; // PostMapper Bean을 클래스에 주입.

    @Test
    void save() { // 저장 
        PostRequest params = new PostRequest();
        params.setTitle("1번 게시글 제목");
        params.setContent("1번 게시글 내용");
        params.setWriter("테스터");
        params.setNoticeYn(false);
        postMapper.save(params); // save

        List<PostResponse> posts = postMapper.findAll();
        System.out.println("전체 게시글 개수는 : " + posts.size() + "개입니다.");
    }

    @Test
    void findById() { // 상세조회
        PostResponse post = postMapper.findById(1L); // select one, PK값인 long type 1을 전달.
        try {
            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
            System.out.println(postJson); // JSON 문자열(KEY-VALUE)로 출력.

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void update() { // 수정
        // 1. 게시글 수정
        PostRequest params = new PostRequest();
        params.setId(1L);
        params.setTitle("1번 게시글 제목 수정합니다.");
        params.setContent("1번 게시글 내용 수정합니다.");
        params.setWriter("도뎡이");
        params.setNoticeYn(true);
        postMapper.update(params); // update

        // 2. 게시글 상세정보 조회
        PostResponse post = postMapper.findById(1L); // select one
        try {
            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
            System.out.println(postJson);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void delete() { // 삭제
        System.out.println("삭제 이전의 전체 게시글 개수는 : " + postMapper.findAll().size() + "개입니다.");
        postMapper.deleteById(1L); // delete one
        System.out.println("삭제 이후의 전체 게시글 개수는 : " + postMapper.findAll().size() + "개입니다.");
    }
}
