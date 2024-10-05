package com.study.pjt002.common.dto;

import com.study.pjt002.common.paging.Pagination;
import lombok.Getter;
import lombok.Setter;

/**
 * packageName    : com.study.pjt002.common.dto
 * fileName       : SearchDto
 * author         : dotdot
 * date           : 2024-10-05
 * description    : 페이징, 검색용
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-05        dotdot       최초 생성
 */

@Getter
@Setter
public class SearchDto {

    private int page;               // 현재 페이지 번호
    private int recordSize;         // 페이지당 출력할 데이터 개수
    private int pageSize;           // 화면 하단에 출력할 페이지 사이즈
    private String keyword;         // 검색 키워드
    private String searchType;      // 검색 유형
    private Pagination pagination;  // 페이지네이션 정보

    private SearchDto() {       // 생성자, Constructor
        this.page = 1;          // 초기 1 페이지
        this.recordSize = 10;   // 출력할 row 10개 
        this.pageSize = 10;     // 최대 10 페이지 
    }

//    private int getOffset() {   //
//        return (page - 1) * recordSize;
//    }
}
