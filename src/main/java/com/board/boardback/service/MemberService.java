package com.board.boardback.service;

import com.board.boardback.dto.MemberDto;

import java.util.List;

public interface MemberService {
    /**
     * 회원 정보 저장
     * @param memberDto
     * @return 회원 아이디
     * 
     */
    String saveMember(MemberDto memberDto);

    /**
     * 전체 회원 정보 조회
     * @return 모든 회원 정보 목록
     */
    List<MemberDto> findAll();

    /**
     * 
     * @param memberDto
     * @return 아이디 기준으로 해당 회원 정보
     */
    MemberDto findById(MemberDto memberDto);

    /**
     * 
     * @param memberDto
     * @return 로그인한 정보 매칭 확인 및 회원 정보
     */
    boolean findByMemberIdAndMemberPw(MemberDto memberDto);
    
    /**
     * 
     * @param memberDto
     * @return 회원 아이디 중복 계정 목록
     */
    boolean getDuplicateId(MemberDto memberDto);

    /**
     * 
     * @param memberDto
     * @return 회원 정보 조회 후 회원 접근 수준 정보
     */
    String getMemberAccLvl(MemberDto memberDto);

    /**
     * 
     * @param memberDto
     * @return 수정된 회원 정보
     */
    MemberDto updateMember(MemberDto memberDto);

    /**
     * 
     * @param memberDto
     * @ 회원 정보 삭제
     */
    void deleteMember(MemberDto memberDto);
}
