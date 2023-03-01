package com.board.boardback.dto;

import com.board.boardback.domain.Board;
import com.board.boardback.domain.Comment;
import com.board.boardback.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
public class MemberDto {
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberTelNum;
    private String memberAddress;
    private Date joinDate;
    private String accLvl;
    private List<Board> boards = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();
    
    /**
     * 회원가입 정보 전달
     *
     * @param memberId
     * @param memberPw
     * @param memberName
     * @param memberTelNum
     * @param memberAddress
     * @param joinDate
     * @param accLvl
     */
    public MemberDto(String memberId, String memberPw, String memberName, String memberTelNum, String memberAddress, Date joinDate, String accLvl) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberTelNum = memberTelNum;
        this.memberAddress = memberAddress;
        this.joinDate = joinDate;
        this.accLvl = accLvl;
    }

    /**
     * 아이디 전달
     * @param memberId
     */
    public MemberDto(String memberId) {
        this.memberId = memberId;
    }

    /**
     *  아이디, 비밀번호 전달
     *
     * @param memberId
     * @param memberPw
     */
    public MemberDto(String memberId, String memberPw) {
        this.memberId = memberId;
        this.memberPw = memberPw;
    }

    /**
     * 
     * 전체 정보 전달
     */
    public MemberDto(String memberId, String memberPw, String memberName, String memberTelNum, String memberAddress, Date joinDate, String accLvl, List<Board> boards, List<Comment> comments) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberTelNum = memberTelNum;
        this.memberAddress = memberAddress;
        this.joinDate = joinDate;
        this.accLvl = accLvl;
        this.boards = boards;
        this.comments = comments;
    }

    public MemberDto(Member member) {
        this.memberId = member.getMemberId();
        this.memberPw = member.getMemberPw();
        this.memberName = member.getMemberName();
        this.memberTelNum = member.getMemberTelNum();
        this.memberAddress = member.getMemberAddress();
        this.joinDate = member.getJoinDate();
        this.accLvl = member.getAccLvl();
        this.boards = member.getBoards();
        this.comments = member.getComments();
    }

    public Member dtoToMemberEntity() {
        return Member.builder()
                .memberId(memberId)
                .memberPw(memberPw)
                .memberName(memberName)
                .memberTelNum(memberTelNum)
                .memberAddress(memberAddress)
                .joinDate(joinDate)
                .accLvl(accLvl)
                .boards(boards)
                .comments(comments)
                .build();
    }

}
