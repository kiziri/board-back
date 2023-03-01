package com.board.boardback.domain;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 알아서 생성해주는 것으로
    @Column(name = "commentId")
    private long commentId;
    @Column(name = "content")
    private String content;
    @Column(name = "commentDate")
    private String commentDate;
    @Column(name = "isCoComent")
    private String isCoComment;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "boardId")
    private Board board;

    // 연관 관계 메서드 //
    public void setMember(Member member) {
        this.member = member;
        member.getComments().add(this);
    }

    // 연관 관계 메서드 //
    public void setBoard(Board board) {
        this.board = board;
        board.getComments().add(this);
    }

    public static Comment createComment(Comment commentInfo, Member member) {
        Comment comment = new Comment();


        return comment;
    }
}
