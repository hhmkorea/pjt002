package com.study.pjt002.domain.post;

import com.study.pjt002.common.dto.MessageDto;
import com.study.pjt002.common.dto.SearchDto;
import com.study.pjt002.common.file.FileUtils;
import com.study.pjt002.common.paging.PagingResponse;
import com.study.pjt002.domain.file.FileRequest;
import com.study.pjt002.domain.file.FileResponse;
import com.study.pjt002.domain.file.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * packageName    : com.study.pjt002.domain.post
 * fileName       : PostController
 * author         : dotdot
 * date           : 2024-10-04
 * description    : 서비스 호출하고 그에 대한 실행 결과 전달
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-04        dotdot       최초 생성
 */
@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final FileService fileService; // 파일 업로드 서비스
    private final FileUtils fileUtils; // 파일 업로드 유틸

    // 사용자에게 메시지를 전달하고, 페이지를 redirect 한다.
    private String showMessageAndRedirect(final MessageDto params, Model model) {
        model.addAttribute("params", params);
        return "common/messageRedirect";
    }

    // 쿼리 스트링 parameter를 Map에 담아 반환
    private Map<String, Object> queryParamsToMap(final SearchDto queryParams) {
        Map<String, Object> data = new HashMap<>();
        data.put("page", queryParams.getPage());
        data.put("recodeSize", queryParams.getRecordSize());
        data.put("pageSize", queryParams.getPageSize());
        data.put("keyword", queryParams.getKeyword());
        data.put("searchType", queryParams.getSearchType());
        return data;
    }

    // 게시글 작성 페이지
    @GetMapping("/post/write.do")
    public String openPostWrite(@RequestParam(value = "id", required = false) final Long id, Model model) { // @RequestParam : HTML에서 보낸 파라매터 전달 받는데 사용

        if (id != null) {
            PostResponse post = postService.findPostById(id);
            model.addAttribute("post", post);
        }
        return "post/write"; // src/main/resources/templates/post/write.html
    }

    // 신규 게시글 생성
    @PostMapping("/post/save.do")
    public String savePost(final PostRequest params, Model model) { // PostRequest : 게시글(+첨부파일) 등록 요청 데이터를 담은 통(class).
        Long id = postService.savePost(params); // 1. 게시글 저장 성공 후 게시글 id 받아둠.
        List<FileRequest> files = fileUtils.uploadFiles(params.getFiles()); // 2. 디스크에 파일 업로드
        fileService.saveFiles(id, files); // 3. 업로드 된 파일 정보를 DB에 저장
        MessageDto message = new MessageDto("게시글 생성이 완료되었습니다.", "/post/list.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    // 게시글 리스트 페이지
    @GetMapping("/post/list.do")
    public String openPostList(@ModelAttribute("params") final SearchDto params, Model model) {
        PagingResponse<PostResponse> response = postService.findAllPost(params);
        model.addAttribute("response", response);
        return "post/list"; // src/main/resources/templates/post/list.html
    }

    // 게시글 상세 페이지
    @GetMapping("/post/view.do")
    public String openPostView(@RequestParam final Long id, Model model) {
        PostResponse post = postService.findPostById(id);
        model.addAttribute("post", post);
        return "post/view"; // src/main/resources/templates/post/view.html
    }

    // 기존 게시글 수정
    @PostMapping("/post/update.do")
    public String updatePost(final PostRequest params, final SearchDto queryParams, Model model) {

        // 1. 게시글 정보 수정
        postService.updatePost(params);

        // 2. 파일 업로드 (to disk)
        List<FileRequest> uploadFiles = fileUtils.uploadFiles(params.getFiles());

        // 3. 파일 정보 저장 (to database)
        fileService.saveFiles(params.getId(), uploadFiles);

        // 4. 삭제할 파일 정보 조회 (from database)
        List<FileResponse> deleteFiles = fileService.findAllFileByIds(params.getRemoveFileIds());

        // 5. 파일 삭제 (from disk)
        fileUtils.deleteFiles(deleteFiles);

        // 6. 파일 삭제 (from database)
        fileService.deleteAllFileByIds(params.getRemoveFileIds());

        MessageDto message = new MessageDto("게시글 수정이 완료되었습니다.", "/post/list.do", RequestMethod.GET, queryParamsToMap(queryParams));// queryParams: 이전 페이지 정보.
        return showMessageAndRedirect(message, model);
    }

    // 게시글 삭제
    @PostMapping("/post/delete.do")
    public String deletePost(@RequestParam final Long id, final SearchDto queryParams, Model model) { // view.html의 deleteForm name="id" 값을 받아서 처리함.
        postService.deletePost(id);
        MessageDto message = new MessageDto("게시글 삭제가 완료되었습니다.", "/post/list.do", RequestMethod.GET, queryParamsToMap(queryParams)); // queryParams: 이전 페이지 정보.
        return showMessageAndRedirect(message, model);
    }

}
