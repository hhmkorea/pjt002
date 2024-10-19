package com.study.pjt002.domain.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * packageName    : com.study.pjt002.domain.member
 * fileName       : MemberController
 * author         : dotdot
 * date           : 2024-10-11
 * description    : 회원 관련 페이지와 데이터의 CRUD를 처리하는 Controller
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-11        dotdot       최초 생성
 */

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 로그인 페이지
    @GetMapping("/login.do")
    public String openLogin() {
        return "member/login";
    }

    // 회원 정보 저장 (회원가입)
    @PostMapping("/members")
    @ResponseBody
    public Long saveMember(@RequestBody final MemberRequest params) {
        return memberService.saveMember(params);
    }

    // 회원 상세정보 조회
    @GetMapping("/members/{loginId}")
    @ResponseBody
    public MemberResponse findMemberByLoginId(@PathVariable final String loginId) {
        return memberService.findMemberByLoginId(loginId);
    }

    // 회원 정보 수정
    @PatchMapping("/members/{id}")
    @ResponseBody
    public Long updateMember(@PathVariable final Long id, @RequestBody final MemberRequest params) {
        return memberService.updateMember(params);
    }

    // 회원 정보 삭제 (회원 탈퇴)
    @DeleteMapping("/members/{id}")
    @ResponseBody
    public Long deleteMemberById(final Long id) {
        return memberService.deleteMemberById(id);
    }

    // 회원 수 카운팅 (ID 중복 체크)
    @GetMapping("/member-count")
    @ResponseBody
    public int countMemberByLoginId(@RequestParam final String loginId) {
        return memberService.countMemberByLoginId(loginId);
    }

    // 로그인
    @PostMapping("/login")
    @ResponseBody
    public MemberResponse login(HttpServletRequest request) {

        // 1. 회원 정보 조회
        String loginId = request.getParameter("loginId");
        String password = request.getParameter("password");
        MemberResponse member = memberService.login(loginId, password);

        // 2. 세션에 회원 정보 저장 & 세션 유지 시간 설정
        if ( member != null ) {
            HttpSession session = request.getSession();;
            session.setAttribute("loginMember", member); // body.html에 session.loginMember 로 session 연결시 로컬 저장소에 저장되어 있음.
            session.setMaxInactiveInterval(60 * 30); // 1800초 = 30분
        }

        return member;
    }

    // 로그아웃
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login.do"; // redirect: 사용자가 처음 요청한 URL이 아닌 지정한 URL로 보냄.
    }
}
