package com.board.boardback.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 알아서 생성해주는 것으로
    @Column(name = "board_id")
    private long boardId;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "write_date")
    private Date wrie_date;
    @Column(name = "view_count")
    private int view_count;
    @Column(name = "comment_count")
    private int comment_count;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany
    private List<Comment> comments;

    // 연관 관계 메서드 //
    public void setMember(Member member) {
        this.member = member;
        member.getBoards().add(this);
    }


}
