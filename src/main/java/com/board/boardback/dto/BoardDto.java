package com.board.boardback.dto;

import com.board.boardback.domain.Board;
import com.board.boardback.domain.Comment;
import com.board.boardback.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
public class BoardDto {
    private long boardId;
    private String title;
    private String content;
    private Date wrieDate;
    private int viewCount;
    private int commentCount;
    private Member member;
    private List<Comment> comments;

    public BoardDto(long boardId, String title, String content, Date wrieDate, int viewCount, int commentCount, Member member, List<Comment> comments) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.wrieDate = wrieDate;
        this.viewCount = viewCount;
        this.commentCount = commentCount;
        this.member = member;
        this.comments = comments;
    }

    public BoardDto(long boardId, String title, String content, Date wrieDate, int viewCount, Member member) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.wrieDate = wrieDate;
        this.viewCount = viewCount;
        this.member = member;
    }

    public BoardDto(long boardId, int viewCount, int commentCount) {
        this.boardId = boardId;
        this.viewCount = viewCount;
        this.commentCount = commentCount;
    }

    public BoardDto(long boardId, int viewCount, int commentCount, List<Comment> comments) {
        this.boardId = boardId;
        this.viewCount = viewCount;
        this.commentCount = commentCount;
        this.comments = comments;
    }

    public BoardDto(long boardId, List<Comment> comments) {
        this.boardId = boardId;
        this.comments = comments;
    }

    public BoardDto(long boardId) {
        this.boardId = boardId;
    }

    public BoardDto(long boardId, int viewCount) {
        this.boardId = boardId;
        this.viewCount = viewCount;
    }

    public BoardDto(Board board) {
        this.boardId = board.getBoardId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.wrieDate = board.getWrieDate();
        this.viewCount = board.getViewCount();
        this.commentCount = board.getViewCount();
        this.member = board.getMember();
        this.comments = board.getComments();
    }

    public Board dtoToBoardEntity() {
        return Board.builder()
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
