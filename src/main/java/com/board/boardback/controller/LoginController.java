package com.board.boardback.controller;

import com.board.boardback.dto.MemberDto;
import com.board.boardback.service.MemberServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Api(tags = {"2. login"})
@RequiredArgsConstructor
@RestController("/v1/login")
public class LoginController {
    private final MemberServiceImpl memberService;

    @PostMapping("/requestLogin")
    public MemberDto getLoginMemberInfo(@ApiParam(value = "로그인 req", required = true)
                                            @RequestBody MemberDto memberDto/*, HttpServletRequest request*/) {


        boolean isLogin = memberService.findByMemberIdAndMemberPw(memberDto);
        if (isLogin) {
            MemberDto loginMember = memberService.findById(memberDto);
//            HttpSession httpSession = request.getSession(true);
//            httpSession.setAttribute("member", loginMember);
            return loginMember;
        }
        return new MemberDto();
    }

    @PostMapping("/findPassword")
    public MemberDto findMemberPassword(@ApiParam(value = "회원 비밀번호 찾기 req", required = true)
                                @RequestBody MemberDto memberDto) {

        MemberDto searchMember = memberService.findById(memberDto);

        if (searchMember.getMemberId().equals(memberDto.getMemberId())) {
            memberService.updateMember(memberDto);
            searchMember = memberService.findById(memberDto);
        }

        return searchMember;
    }
}
