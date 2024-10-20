package com.study.pjt002.domain.file;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * packageName    : com.study.pjt002.domain.file
 * fileName       : FileMapper
 * author         : dotdot
 * date           : 2024-10-19
 * description    : 파일 업로드 CRUD
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-19        dotdot       최초 생성
 */

@Mapper
public interface FileMapper {

    /**
     * 파일 정보 저장
     * @param files - 파일 정보 리스트
     */
    void saveAll(List<FileRequest> files); // 여러 개의 파일 정보를 한 번에 저장하기 위해 List 타입으로 선언.

    /**
     * 파일 리스트 조회
     * @param postId - 게시글 번호 (FK)
     * @return 파일 리스트
     */
    List<FileResponse> findAllByPostId(Long postId);

    /**
     * 파일 리스트 조회
     * @param ids - PK 리스트, 리스트 타입의 파일 번호
     * @return 파일 리스트
     */
    List<FileResponse> findAllByIds(List<Long> ids);

    /**
     * 파일 삭제
     * @param ids - PK 리스트, 리스트 타입의 파일 번호
     */
    void deleteAllByIds(List<Long> ids);
}
