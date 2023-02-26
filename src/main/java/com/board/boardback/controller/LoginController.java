package com.board.boardback.controller;

import com.board.boardback.dto.MemberDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("/v1/login")
public class LoginController {

    @PostMapping("/requestlogin")
    public List<MemberDto> getLoginMemberInfo() {
        List<MemberDto> loginMember = new ArrayList<>();

        return loginMember;
    }
}
