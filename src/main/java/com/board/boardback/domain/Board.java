package com.board.boardback.domain;

import com.board.boardback.dto.BoardDto;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 알아서 생성해주는 것으로
    @Column(name = "boardId")
    private long boardId;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "wrieDate")
    private Date wrieDate;
    @Column(name = "viewCount")
    private int viewCount;
    @Column(name = "commentCount")
    private int commentCount;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    @OneToMany
    private List<Comment> comments;

    // 연관 관계 메서드 //
    public void setMember(Member member) {
        this.member = member;
        member.getBoards().add(this);
    }

    public BoardDto entityToBoardDto() {
        return BoardDto.builder()
                .boardId(boardId)
                .title(title)
                .content(content)
                .wrieDate(wrieDate)
                .viewCount(viewCount)
                .commentCount(commentCount)
                .member(member)
                .comments(comments)
                .build();
    }
}
