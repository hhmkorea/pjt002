package com.study.pjt002.common.paging;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : com.study.pjt002.common.paging
 * fileName       : PagingResponse
 * author         : dotdot
 * date           : 2024-10-05
 * description    : 페이징 객체 모두 응답하는 통(class)
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-05        dotdot       최초 생성
 */

@Getter
public class PagingResponse<T> {
    private List<T> list = new ArrayList<>(); // List<T> : Generic, 어떤 타입의 객체이든 데이터를 받겠다는 의미.
    private Pagination pagination; // 계산된 페이지 정보를 해당 변수에 저장.

    public PagingResponse(List<T> list, Pagination pagination) {
        this.list.addAll(list);
        this.pagination = pagination;
    }
}
