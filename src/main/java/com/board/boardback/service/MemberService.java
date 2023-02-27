package com.board.boardback.service;

import com.board.boardback.dto.MemberDto;

import java.util.List;

public interface MemberService {

    public MemberDto save(MemberDto memberDto);
    public List<MemberDto> findAll(MemberDto memberDto);

}
