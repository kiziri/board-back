package com.board.boardback.controller;

import com.board.boardback.dto.MemberDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = {"1. user"})
@RequiredArgsConstructor
@RestController("/v1/user")
public class MemberController {

    @ApiOperation(value = "모든 회원 조회", notes = "모든 회원 목록을 조회합니다.")
    @GetMapping("/retrieveUsers")
    public Object retrieveUser() {

        return new MemberDto();
    }

    @ApiOperation(value = "회원 등록", notes = "신규 회원을 등록합니다.")
    @PostMapping("/saveUser")
    public MemberDto saveUser() {
        MemberDto memberDto = new MemberDto();


        return memberDto;
    }
}
