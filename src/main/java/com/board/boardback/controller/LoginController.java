package com.board.boardback.controller;

import com.board.boardback.model.MemberDto;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    public List<MemberDto> getLoginMemberInfo() {
        List<MemberDto> loginMember = new ArrayList<>();

        return loginMember;
    }
}
