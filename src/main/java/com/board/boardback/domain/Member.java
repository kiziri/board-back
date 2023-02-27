package com.board.boardback.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @Column(name = "member_serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 알아서 생성해주는 것으로
    private long member_serial;

    @Column(name = "member_id") // 회원 로그인 아이디
    private String memberId;

    @Column(name = "member_pw")
    private String password;

    @Column(name = "member_name")
    private String name;

    @Column(name = "member_telnumber")
    private String telNumber;

    @Column(name = "member_address")
    private String address;

    @Column(name = "join_date")
    private Date join_date;

    @Column(name = "acc_lvl")
    private String acc_lvl;

    @OneToMany(mappedBy = "member")
    private List<Board> boards = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<File> files = new ArrayList<>();


    public boolean getMatchPassword(String password) {
        return this.password.equals(password);
    }
}
