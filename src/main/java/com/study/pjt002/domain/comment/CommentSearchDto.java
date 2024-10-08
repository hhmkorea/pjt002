package com.study.pjt002.domain.comment;

import com.study.pjt002.common.dto.SearchDto;
import lombok.Getter;
import lombok.Setter;

/**
 * packageName    : com.study.pjt002.domain.comment
 * fileName       : CommentSearchDto
 * author         : dotdot
 * date           : 2024-10-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-08        dotdot       최초 생성
 */

@Getter
@Setter
public class CommentSearchDto extends SearchDto {

    private Long postId;        // 게시글 번호 (FK)
}
