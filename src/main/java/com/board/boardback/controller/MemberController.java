package com.board.boardback.controller;

import com.board.boardback.dto.MemberDto;
import com.board.boardback.service.MemberServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(tags = {"1. user"})
@RequiredArgsConstructor
@RestController("/v1/user")
public class MemberController {
    private final MemberServiceImpl memberService;

    @ApiOperation(value = "회원 정보 조회", notes = "요청한 회원 정보를 조회합니다.")
    @GetMapping("retrieveUser")
    public MemberDto retrieveUser(@ApiParam(value = "단일 회원 정보 조회 req", required = true) String memberId) {
        MemberDto memberDto = new MemberDto(memberId);

        return memberService.findById(memberDto);
    }

    @ApiOperation(value = "모든 회원 조회", notes = "모든 회원 목록을 조회합니다.")
    @GetMapping("/retrieveUsers")
    public List<MemberDto> retrieveUsers() {
        return memberService.findAll();
    }

    @ApiOperation(value = "회원 등록", notes = "신규 회원을 등록합니다.")
    @PostMapping("/saveUser")
    public String saveUser(@ApiParam(value = "신규 회원 정보 req", required = true)
                            @RequestBody MemberDto memberDto) {

        MemberDto newMember = new MemberDto(memberDto.getMemberId(), memberDto.getMemberPw(),
                memberDto.getMemberName(), memberDto.getMemberTelNum(), memberDto.getMemberAddress(),
                memberDto.getJoinDate(), "1");

        return memberService.saveMember(newMember);
    }
}
