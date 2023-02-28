package com.board.boardback.service;

import com.board.boardback.dto.MemberDto;

import java.util.List;

public interface MemberService {
    /**
     * 
     * @param memberDto
     * @return 회원 정보 저장
     */
    public MemberDto saveMember(MemberDto memberDto);

    /**
     * 
     * @param memberDto
     * @return 모든 회원 정보 목록
     */
    public List<MemberDto> findAll(MemberDto memberDto);

    /**
     * 
     * @param memberDto
     * @return 특정 회원 정보
     */
    public MemberDto findOne(MemberDto memberDto);

    /**
     * 
     * @param memberDto
     * @return 아이디 기준으로 해당 회원 정보
     */
    public MemberDto findById(MemberDto memberDto);

    /**
     * 
     * @param memberDto
     * @return 로그인한 회원 정보
     */
    public MemberDto getLoginMember(MemberDto memberDto);

    /**
     * 
     * @param memberDto
     * @return 회원 아이디 중복 계정 목록
     */
    public List<MemberDto> getCheckDuplicateId(MemberDto memberDto);

    /**
     * 
     * @param memberDto
     * @return 회원의 접근 수준 정보 
     */
    public MemberDto getAccLvl(MemberDto memberDto);

    /**
     * 
     * @param memberDto
     * @return 수정된 회원 정보
     */
    public MemberDto updateMember(MemberDto memberDto);

    /**
     * 
     * @param memberDto
     * @ 회원 정보 삭제
     */
    public void deleteMember(MemberDto memberDto);
}
