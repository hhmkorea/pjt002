package com.study.pjt002.common.file;

import com.study.pjt002.domain.file.FileRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * packageName    : com.study.pjt002.common.file
 * fileName       : FileUtils
 * author         : dotdot
 * date           : 2024-10-19
 * description    : 스크에 디렉터리(폴더)를 생성하거나, 파일을 업로드 또는 삭제하는 용도로 사용되는 클래스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-19        dotdot       최초 생성
 */

@Component // 개발자가 직접 정의한 클래스를 빈으로 등록할 때 사용.
public class FileUtils {

    private final String uploadPath = Paths.get("C:", "develop", "upload-files").toString(); // C: \ develop \ upload-files
    // Paths.get() : OS 상관없이 디렉터리 경로 구분.

    /**
     * 다중 파일 업로드
     * @param multipartFiles - 파일 객체 List
     * @return DB에 저장할 파일 정보 List
     */
    public List<FileRequest> uploadFiles(final List<MultipartFile> multipartFiles) { // MultipartFile : 스프링 파일 업로드 인터페이스
        List<FileRequest> files = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            if (multipartFile.isEmpty()) {
                continue;
            }
            files.add(uploadFile(multipartFile));
        }
        return files;
    }

    /**
     * 단일 파일 업로드
     * @param multipartFile - 파일 객체
     * @return DB에 저장할 파일 정보
     */
    public FileRequest uploadFile(final MultipartFile multipartFile) {

        if (multipartFile.isEmpty()) {
            return null;
        }

        String saveName = generateSaveFileName(multipartFile.getOriginalFilename()); // generateSaveFileName() : 파일명 생성, 예:89c12f6b3a0e4aeabae2c5a8d7e474d0.png
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd")).toString();
        String uploadPath = getUploadPath(today) + File.separator + saveName; // 실제디스크에 저장되는 파일명. 예:241019/00000.txt
        // getUploadPath() : 업로드 경로 반환,
        // File.separator : 파일 디렉토리 구분자 지정. 윈도우 \\, 리눅스 / 인데 이걸로 통일시킴.

        File uploadFile = new File(uploadPath);

        try {
            multipartFile.transferTo(uploadFile); // transferTo() : 지정한 경로로 파일 저장, 경로가 지저분하므로 지정해서 관리.
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return FileRequest.builder()
                .originalName(multipartFile.getOriginalFilename())
                .saveName(saveName)
                .size(multipartFile.getSize())
                .build();
    }

    /**
     * 저장 파일명 생성
     * @param filename 원본 파일명
     * @return 디스크에 저장할 파일명
     */
    private String generateSaveFileName(final String filename) {
        String strUuid = UUID.randomUUID().toString().replaceAll("-", "");// UUID : Universally Unique Identifier, SW 구축에 쓰이는 식별자 표준.
        String extension = StringUtils.getFilenameExtension(filename); // getFilenameExtension() : java 파일 확장자 가져오기.
        return strUuid + "." + extension;
    }

    /**
     * 업로드 경로 반환
     * @param addPath - 추가 경로
     * @return 업로드 경로
     */
    private String getUploadPath(final String addPath) {
        return makeDirectories(uploadPath + File.separator + addPath); // 업로드 폴더 생성.
    }

    /**
     * 업로드 폴더(디렉토리) 생성
     * @param path - 업로드 경로
     * @return - 업로드 경로
     */
    private String makeDirectories(final String path) {
        File dir = new File(path);
        if (dir.exists() == false) { // 디시크 경로에 해당되는 폴더가 없으면 path에 해당되는 모든 경로에 폴더를 생성.
            dir.mkdirs();
        }
        return dir.getPath();
    }
}
