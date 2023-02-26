package com.board.boardback.dto;

import com.board.boardback.domain.Board;
import com.board.boardback.domain.Comment;
import com.board.boardback.domain.File;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class MemberDto {
    private long member_serial;
    private String member_id;
    private String password;
    private String name;
    private String telNumber;
    private String address;
    private String join_date;
    private String acc_lvl;
    private List<Board> boards = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();
    private List<File> files = new ArrayList<>();

    public MemberDto(String member_id, String password, String name, String telNumber, String address, String join_date, String acc_lvl) {
        this.member_id = member_id;
        this.password = password;
        this.name = name;
        this.telNumber = telNumber;
        this.address = address;
        this.join_date = join_date;
        this.acc_lvl = acc_lvl;
    }
}
