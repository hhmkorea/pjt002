package com.study.pjt002.domain.file;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * packageName    : com.study.pjt002.domain.file
 * fileName       : FileService
 * author         : dotdot
 * date           : 2024-10-19
 * description    : 파일 비즈니스 로직(DB에 저장할 피일의 논리적인 정보) 담당 서비스.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-19        dotdot       최초 생성
 */

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileMapper fileMapper;

    @Transactional
    public void saveFiles(final Long postId, final List<FileRequest> files) {
        if (CollectionUtils.isEmpty(files)) { // Collection(동적 배열, List, Map, Set)의 종류의 값들 존재 여부 판단하는 메서드.
            return;
        }
        for (FileRequest file : files) {
            file.setPostId(postId);
        }
        fileMapper.saveAll(files);
    }
}
