package com.board.boardback.dto;

import com.board.boardback.domain.Board;
import com.board.boardback.domain.Comment;
import com.board.boardback.domain.File;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class MemberDto {
    private long member_serial;
    private String memberId;
    private String password;
    private String name;
    private String telNumber;
    private String address;
    private String joinDate;
    private String accLvl;
    private List<Board> boards = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();
    private List<File> files = new ArrayList<>();

    /**
     * 
     * 전체 정보 전달
     */
    public MemberDto(String memberId, String password, String name, String telNumber, String address, String joinDate, String accLvl, List<Board> boards, List<Comment> comments, List<File> files) {
        this.memberId = memberId;
        this.password = password;
        this.name = name;
        this.telNumber = telNumber;
        this.address = address;
        this.joinDate = joinDate;
        this.accLvl = accLvl;
        this.boards = boards;
        this.comments = comments;
        this.files = files;
    }

    /**
     *  회원가입에 대한 정보 전달
     * 
     * @param memberId
     * @param password
     * @param name
     * @param telNumber
     * @param address
     * @param joinDate
     * @param accLvl
     */
    public MemberDto(String memberId, String password, String name, String telNumber, String address, String joinDate, String accLvl) {
        this.memberId = memberId;
        this.password = password;
        this.name = name;
        this.telNumber = telNumber;
        this.address = address;
        this.joinDate = joinDate;
        this.accLvl = accLvl;
    }

    /**
     *  아이디, 비밀번호 전달
     * 
     * @param memberId
     * @param password
     */
    public MemberDto(String memberId, String password) {
        this.memberId = memberId;
        this.password = password;
    }
    
    
}
