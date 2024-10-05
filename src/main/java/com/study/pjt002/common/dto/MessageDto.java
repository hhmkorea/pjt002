package com.study.pjt002.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * packageName    : com.study.pjt002.common.dto
 * fileName       : MessageDto
 * author         : dotdot
 * date           : 2024-10-05
 * description    : 메세지 처리용
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-05        dotdot       최초 생성
 */

@Getter
@AllArgsConstructor // 전체 멤버 변수를 필요로 하는 생성자 생성
public class MessageDto {

    private String message;             // 사용자에게 전달할 메시지
    private String redirectUri;         // 다이렉트 URI(Uniform Resource Identifier), 통합 자원 식별자
    private RequestMethod method;       // HTTP 요청 메서드, RequestMethod : enum 처리용
    private Map<String, Object> data;   // 화면(View)로 전달할 데이터(parameter)
    
}
