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
}
