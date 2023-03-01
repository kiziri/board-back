package com.board.boardback.domain;

import com.board.boardback.dto.MemberDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @Column(name = "memberId") // 회원 로그인 아이디
    private String memberId;

    @Column(name = "memberPw")
    private String memberPw;

    @Column(name = "memberName")
    private String memberName;

    @Column(name = "memberTelNum")
    private String memberTelNum;

    @Column(name = "memberAddress")
    private String memberAddress;

    @Column(name = "joinDate")
    private Date joinDate;

    @Column(name = "accLvl")
    private String accLvl;

    @OneToMany(mappedBy = "member")
    private List<Board> boards = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Comment> comments = new ArrayList<>();


    public boolean getMatchPassword(String memberPw) {
        return this.memberPw.equals(memberPw);
    }

    public MemberDto entityToMemberDto() {
        return MemberDto.builder()
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
